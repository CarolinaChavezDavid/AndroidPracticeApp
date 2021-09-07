package com.example.myappcarolina.series.data.api

import com.example.myappcarolina.series.domain.model.SeriesDto
import retrofit2.http.GET

interface SeriesApiService {
    @GET("series/")
    fun getSeriesList(): retrofit2.Call<List<SeriesDto>>
}