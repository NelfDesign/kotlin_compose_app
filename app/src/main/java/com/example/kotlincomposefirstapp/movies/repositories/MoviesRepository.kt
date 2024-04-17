package com.example.kotlincomposefirstapp.movies.repositories

import com.example.kotlincomposefirstapp.movies.models.Wizard
import com.example.kotlincomposefirstapp.movies.movies_api_service.RetrofitMoviesInstance

class MoviesRepository {
    suspend fun getAllCharacters() : List<Wizard> {
        return RetrofitMoviesInstance.api.getAllCharacters()
    }
}