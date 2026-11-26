package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CatalogDao {

    @Query(
        """
        SELECT * FROM readings_catalog
        WHERE (:categoryName IS NULL OR categoryName = :categoryName)
          AND (:query = '' OR title LIKE '%' || :query || '%'
               OR subtitle LIKE '%' || :query || '%'
               OR subGenre LIKE '%' || :query || '%'
               OR searchableContent LIKE '%' || :query || '%')
        ORDER BY sortOrder ASC
        """
    )
    fun observeFilteredReadings(
        categoryName: String?,
        query: String
    ): Flow<List<ReadingEntity>>

    @Query("SELECT COUNT(*) FROM readings_catalog")
    suspend fun getReadingCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(readings: List<ReadingEntity>)
}
