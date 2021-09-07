package com.example.myappcarolina.series.data.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myappcarolina.series.domain.model.SeriesDto

@Dao
interface SerieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSerie(serieEntity: List<SeriesDto>)

    @Query("SELECT * FROM Series")
    fun readAllSeries() : LiveData<List<SeriesDto>>
}