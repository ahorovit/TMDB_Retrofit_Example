package com.drspaceman.tmdb_retrofit_example.service

import com.drspaceman.tmdb_retrofit_example.data.TmdbMovie

class MovieRepository(private val api: TmdbApi) : BaseRepository() {

    suspend fun getPopularMovies(): List<TmdbMovie>? {
        val movieResponse = safeApiCall(
            call = { api.getPopularMovie().await() },
            errorMessage = "Error fetching popular movies"
        )

        return movieResponse?.results?.toMutableList()
    }
}