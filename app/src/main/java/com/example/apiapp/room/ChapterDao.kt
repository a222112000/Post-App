package com.example.apiapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChapterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: chapterCacheEntity):Long

    @Query("SELECT * FROM post")
    suspend fun get(): List<chapterCacheEntity>
}