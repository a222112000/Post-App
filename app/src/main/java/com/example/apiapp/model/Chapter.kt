package com.example.apiapp.model

import com.google.gson.annotations.SerializedName

data class Chapter(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
