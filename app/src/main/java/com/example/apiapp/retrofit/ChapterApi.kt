package com.example.apiapp.retrofit

import com.example.apiapp.model.ChaptersItem
import retrofit2.http.GET

interface ChapterApi {
    @GET("posts")
    suspend fun getAllChapters(): List<ChaptersItem>
}