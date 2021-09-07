package com.example.myappcarolina.movies.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myappcarolina.movies.RoomApplication
import com.example.myappcarolina.movies.model.MovieModel
import com.example.myappcarolina.movies.moviesapi.MovieApiServices
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRepository {

    var roomApplication = RoomApplication()
    var myDisposable  = CompositeDisposable()

    fun getMovies(context: Context): LiveData<List<MovieModel>> {
        //Log.e("Caro", roomApplication.getMoviesDatabase(context).toString())
        //Log.e("movieDao", roomApplication.getMoviesDatabase(context).movieDao().toString())
       // Log.e("all", roomApplication.getMoviesDatabase(context).movieDao().readAllMovies().toString())
        return roomApplication.getMoviesDatabase(context).movieDao().readAllMovies()
    }

    fun apiCallPutInBd(context: Context) {

        val movieAPI = "https://api-movie-carolina.herokuapp.com/api/"
        val TAG = "My fav movies"

        val retrofit = Retrofit.Builder()
            .baseUrl(movieAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        val service: MovieApiServices = retrofit.create(MovieApiServices::class.java)

        myDisposable.add(service.getMoviesRX()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { roomApplication.getMoviesDatabase(context).movieDao().addMovie(it) },
                { Log.e(TAG, it.localizedMessage) }
            ))
    }
}