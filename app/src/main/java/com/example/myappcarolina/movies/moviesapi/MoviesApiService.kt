package com.example.myappcarolina.movies.moviesapi

import com.example.myappcarolina.movies.model.MovieModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface MovieApiServices {
    @GET("movies/")
    fun getMoviesRX(): Observable<List<MovieModel>>
}