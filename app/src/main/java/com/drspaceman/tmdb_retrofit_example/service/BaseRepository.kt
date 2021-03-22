package com.drspaceman.tmdb_retrofit_example.service

import android.util.Log
//import okhttp3.Response
import retrofit2.Response
import java.io.IOException

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {
        val result: Result<T> = safeApiResult(call, errorMessage)
        var data: T? = null

        when (result) {
            is Result.Success -> data = result.data
            is Result.Error -> {
                Log.d("1.DataRepository", "$errorMessage & Exception - ${result.exception}")
            }
        }

        return data
    }

    private suspend fun <T : Any> safeApiResult(
        call: suspend () -> Response<T>,
        errorMessage: String
    ): Result<T> {
        val response = call.invoke()

        return if (response.isSuccessful) {
            Result.Success(response.body()!!)
        } else {
            Result.Error(IOException("Error occurred during safeApiResult() - $errorMessage"))
        }
    }
}