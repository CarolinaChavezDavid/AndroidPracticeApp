package com.example.myappcarolina.series.presentation.presenter

import com.example.myappcarolina.series.domain.usecase.GetSeriesUsedCase
import com.example.myappcarolina.series.presentation.view.SeriesFragment

class SeriesPresenter(var view: SeriesFragment) {
    private  var  getSeriesUsedCase = GetSeriesUsedCase()

    fun initSeriesGridView(){
        val list = getSeriesUsedCase.invoke()
        view.initGridView(list)
    }
}