package com.drspaceman.tmdb_retrofit_example.data

data class TmdbReview(
    val id: Int,
    val author: String,
    val content: String,
    val url: String
)

data class TmdbReviewResponse(
        val result: TmdbReview
)