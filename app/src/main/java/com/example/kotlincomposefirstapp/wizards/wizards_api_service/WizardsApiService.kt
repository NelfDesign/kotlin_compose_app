package com.example.kotlincomposefirstapp.wizards.wizards_api_service

import com.example.kotlincomposefirstapp.wizards.models.Spells
import com.example.kotlincomposefirstapp.wizards.models.Wizard
import retrofit2.http.GET

interface WizardsApiService {
    @GET("api/characters")
    suspend fun getAllCharacters() : List<Wizard>

    @GET("api/spells")
    suspend fun getAllSpells() : List<Spells>
}