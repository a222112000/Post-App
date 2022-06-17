package com.example.apiapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class chapterCacheEntity(
    @ColumnInfo(name = "body")
    val body: String,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name ="title")
    val title: String,
    @ColumnInfo(name ="userId")
    val userId: Int
) {
}