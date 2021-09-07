package com.example.myappcarolina.series.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.myappcarolina.series.data.repository.SeriesRepository
import com.example.myappcarolina.series.domain.model.SeriesDto

class GetSeriesUsedCase {
    var seriesRepository = SeriesRepository()

    fun invoke(): MutableLiveData<List<SeriesDto>>{
        return seriesRepository.getSeriesFromServer()
    }
}