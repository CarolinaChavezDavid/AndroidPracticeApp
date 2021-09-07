package com.example.myappcarolina.series.presentation.presenter

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myappcarolina.series.domain.usecase.GetSeriesFromServer
import com.example.myappcarolina.series.domain.usecase.GetSeriesUsedCase
import com.example.myappcarolina.series.presentation.view.SeriesFragment

class SeriesPresenter(var view: SeriesFragment) {
    private  var  getSeriesUsedCase = GetSeriesUsedCase()
    private  var getSeriesFromServer = GetSeriesFromServer()

    fun getAllSeries(context: Context){
        getSeriesFromServer.invokeService(context)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun initSeriesGridView(context: Context){
        val list = getSeriesUsedCase.invoke(context)
        view.initGridView(list)
    }
}