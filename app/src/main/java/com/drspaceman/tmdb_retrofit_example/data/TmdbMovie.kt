package com.drspaceman.tmdb_retrofit_example.data

data class TmdbMovie(
        val id: Int,
        val vote_average: Double,
        val title: String,
        val release_date: String,
        val overview: String,
        val adult: Boolean,
        val poster_path: String?
)

data class TmdbMovieListResponse(
        val results: List<TmdbMovie>
)

data class TmdbMovieResponse(
        val result: TmdbMovie
)