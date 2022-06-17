package com.example.apiapp.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChaptersItem(
    @SerializedName("body")
    @Expose
    val body: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("userId")
    @Expose
    val userId: Int
)