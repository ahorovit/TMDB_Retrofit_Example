package com.drspaceman.tmdb_retrofit_example.data

data class TmdbMovie(
        val id: Int,
        val vote_average: Double,
        val title: String,
        val overview: String,
        val adult: Boolean
)

data class TmdbMovieListResponse(
        val results: List<TmdbMovie>
)

data class TmdbMovieResponse(
        val result: TmdbMovie
)