package com.example.myappcarolina.series.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object {
        const val seriesAPI = "https://api-movie-carolina.herokuapp.com/api/"
        const val TAG= "My fav movies"
    }

    private  val retrofit = Retrofit.Builder()
        .baseUrl(seriesAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var seriesService : SeriesApiService = retrofit.create(SeriesApiService :: class.java)

}