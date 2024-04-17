package com.example.kotlincomposefirstapp.movies.movies_api_service

import com.example.kotlincomposefirstapp.movies.models.Wizard
import retrofit2.http.GET

interface MoviesApiService {
    @GET("api/characters")
    suspend fun getAllCharacters() : List<Wizard>
}