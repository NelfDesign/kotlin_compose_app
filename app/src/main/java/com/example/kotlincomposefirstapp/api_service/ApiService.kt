package com.example.kotlincomposefirstapp.api_service

import com.example.kotlincomposefirstapp.models.APIResults
import retrofit2.http.GET
import retrofit2.http.Query


//APIService configured my call
interface APIService {
    @GET("api/")
    suspend fun getRandomUsers(
        @Query("results") results: String = "50"
    ) : APIResults
}