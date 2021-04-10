package com.drspaceman.tmdb_retrofit_example.service

import com.drspaceman.tmdb_retrofit_example.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiFactory {
    // Middleware to add api key to every request
    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    // HTTP Client for executing network calls
    private val tmdbClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    // Moshi Version 1.9+ require KotlinJsonAdapterFactory to successfully convert JSON into Kotlin class
    private val moshiConverter = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // RESTful wrapper around OkHttpClient -- handles url building/deserialization/thread managment
    fun retrofit(): Retrofit = Retrofit.Builder()
        .client(tmdbClient)
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create(moshiConverter))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val tmdbApi: TmdbApi = retrofit().create(TmdbApi::class.java)
}