package com.example.kotlincomposefirstapp.randomUser.api_service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//BaseURL
private const val baseUrl = "https://randomuser.me/"
object RetrofitInstance {
    val api : APIService by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}