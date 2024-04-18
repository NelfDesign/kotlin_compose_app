package com.example.kotlincomposefirstapp.randomUser.api_service

import com.example.kotlincomposefirstapp.randomUser.models.APIResults
import retrofit2.http.GET
import retrofit2.http.Query


//APIService configured my call
interface APIService {
    @GET("api/")
    suspend fun getRandomUsers(
        @Query("results") results: String = "25"
    ) : APIResults
}