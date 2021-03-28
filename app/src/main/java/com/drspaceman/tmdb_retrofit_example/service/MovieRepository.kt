package com.drspaceman.tmdb_retrofit_example.service

import com.drspaceman.tmdb_retrofit_example.data.TmdbConfig
import com.drspaceman.tmdb_retrofit_example.data.TmdbMovie
import kotlinx.coroutines.*

class MovieRepository(private val api: TmdbApi) : BaseRepository() {
    suspend fun getTmdbApiConfig(): TmdbConfig? {
        val configResponse = safeApiCall(
            { api.getApiConfiguration().await() },
            "Error fetching Tmdb API Configuration"
        )

        return configResponse?.images
    }


    suspend fun getPopularMovies(): List<TmdbMovie>? {
        val movieResponse = safeApiCall(
            call = { api.getPopularMovie().await() },
            errorMessage = "Error fetching popular movies"
        )

        return movieResponse?.results?.toMutableList()
    }

    suspend fun getSelectedMovie(movieId: Int): TmdbMovie? {
        val response = safeApiCall(
                { api.getSelectedMovie(movieId).await() },
                "Error fetching selected movie $movieId"
        )

        return response?.result
    }
}