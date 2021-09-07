package com.example.myappcarolina.series.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myappcarolina.series.data.api.ApiService
import com.example.myappcarolina.series.domain.model.SeriesDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeriesRepository {
    var apiServiceSeries = ApiService()
    var mutableLiveDataSeries = MutableLiveData<List<SeriesDto>>()
    var roomApplicationSeries = RoomApplicationSeries()

    fun getSeries(context: Context): LiveData<List<SeriesDto>> {
        return roomApplicationSeries.getSeriesDatabase(context).serieDao().readAllSeries()
    }

    fun getSeriesFromServer(context: Context) : LiveData<List<SeriesDto>> {
        var call: Call<List<SeriesDto>> = apiServiceSeries.seriesService.getSeriesList()
        call.enqueue(object : Callback<List<SeriesDto>> {
            override fun onResponse(call: Call<List<SeriesDto>>?, response: Response<List<SeriesDto>>?) {
                if (response != null) {
                    Thread(Runnable {
                        roomApplicationSeries.getSeriesDatabase(context).serieDao()
                            .addSerie(response.body()!!)
                        Log.i("My series", response.body().toString())
                    }).start()
                }
            }
            override fun onFailure(call: Call<List<SeriesDto>>?, t: Throwable?) {
                call?.cancel()
            }

        })
        return  mutableLiveDataSeries
    }
}