package com.example.apiapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import okhttp3.internal.Version

@Database(entities = [chapterCacheEntity::class], version = 2)
abstract class PostsDatabase: RoomDatabase() {
    abstract fun chapterDao(): ChapterDao

    companion object{
        val DATABASE_NAME: String = "post_db"
    }
}