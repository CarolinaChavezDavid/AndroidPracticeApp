package com.example.myappcarolina.series.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myappcarolina.series.domain.model.SeriesDto

@Database(entities = [SeriesDto::class], version = 1, exportSchema = true)
abstract class SeriesDatabase :RoomDatabase() {
    abstract fun serieDao():SerieDao
}