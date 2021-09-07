package com.example.myappcarolina.series.domain.usecase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.myappcarolina.series.data.repository.SeriesRepository
import com.example.myappcarolina.series.domain.model.SeriesDto

class GetSeriesFromServer {
    var seriesRepository = SeriesRepository()
    fun invokeService(context: Context): LiveData<List<SeriesDto>> {
        return seriesRepository.getSeriesFromServer(context)
    }
}