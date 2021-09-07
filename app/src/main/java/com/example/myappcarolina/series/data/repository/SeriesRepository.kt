package com.example.myappcarolina.series.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.myappcarolina.series.data.api.ApiService
import com.example.myappcarolina.series.domain.model.SeriesDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeriesRepository {
    var apiServiceSeries = ApiService()
    var mutableLiveDataSeries = MutableLiveData<List<SeriesDto>>()

    fun getSeriesFromServer() : MutableLiveData<List<SeriesDto>> {
        var call: Call<List<SeriesDto>> = apiServiceSeries.seriesService.getSeriesList()
        call.enqueue(object : Callback<List<SeriesDto>> {
            override fun onResponse(
                call: Call<List<SeriesDto>>?,
                response: Response<List<SeriesDto>>?
            ) {
                if (response != null) {
                    mutableLiveDataSeries.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<List<SeriesDto>>?, t: Throwable?) {
                call?.cancel()
            }

        })
        return  mutableLiveDataSeries
    }
}