package com.example.kotlincomposefirstapp.movies.movies_api_service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//BaseURL
private const val baseUrl = "https://hp-api.onrender.com/"
object RetrofitMoviesInstance {
    val api : MoviesApiService by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApiService::class.java)
    }
}