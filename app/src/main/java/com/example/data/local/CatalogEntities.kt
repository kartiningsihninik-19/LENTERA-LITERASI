package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "readings_catalog")
data class ReadingEntity(
    @PrimaryKey val id: String,
    val title: String,
    val subtitle: String,
    val authorOrSource: String,
    val categoryName: String,
    val subGenre: String,
    val readingMinutes: Int,
    val coverKey: String,
    val searchableContent: String,
    val sortOrder: Int
)
