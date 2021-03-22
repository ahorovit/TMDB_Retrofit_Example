package com.drspaceman.tmdb_retrofit_example.service

sealed class Result<out T: Any> {
   data class Success<out T: Any>(val data: T) : Result<T>()
   data class Error(val exception: Exception) : Result<Nothing>()
}