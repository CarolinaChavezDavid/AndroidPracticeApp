package com.example.myappcarolina.series.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Series")
data class SeriesDto (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")val id: Int,
    @ColumnInfo(name = "poster")val poster: String,
    @ColumnInfo(name = "rating")val rating: Double,
    @ColumnInfo(name = "title")val title: String,
    @ColumnInfo(name = "gender")val gender: Double
)