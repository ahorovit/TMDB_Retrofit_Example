package com.drspaceman.tmdb_retrofit_example.service

import com.drspaceman.tmdb_retrofit_example.data.*
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi {
    @GET("/configuration")
    fun getApiConfiguration(): Deferred<Response<TmdbConfigResponse>>

    @GET("movie/popular")
    fun getPopularMovie(): Deferred<Response<TmdbMovieListResponse>>

    @GET("movie/{id}")
    fun getSelectedMovie(@Path("id") movieId: Int): Deferred<Response<TmdbMovieResponse>>

    @GET("movie/latest")
    fun getLatestMovies(): Deferred<Response<TmdbMovieListResponse>>

    @GET("movie/{id}/reviews")
    fun getReviewsForMovie(@Path("id") movieId: Int): Deferred<Response<TmdbReviewResponse>>
}