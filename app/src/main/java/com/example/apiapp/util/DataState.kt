package com.example.apiapp.util

import java.lang.Exception

sealed class DataState<out T> {
    data class Success<out Y>(val data: Y): DataState<Y>()
    data class Error(val exception: Throwable):DataState<Nothing>()
    object Loading: DataState<Nothing>()
}