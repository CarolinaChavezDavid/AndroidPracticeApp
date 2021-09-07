package com.example.myappcarolina.series.data.repository

import android.content.Context
import androidx.room.Room

class RoomApplicationSeries {
    var databaseSeries: SeriesDatabase? = null


    fun getSeriesDatabase(context: Context): SeriesDatabase {
        var dbseries = databaseSeries
        if(dbseries==null){
            dbseries = Room.databaseBuilder(context, SeriesDatabase::class.java,
                "SeriesDb").build()
        }
        return dbseries
    }

}