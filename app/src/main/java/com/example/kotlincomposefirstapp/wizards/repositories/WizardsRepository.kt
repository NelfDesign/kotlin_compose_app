package com.example.kotlincomposefirstapp.wizards.repositories

import com.example.kotlincomposefirstapp.wizards.models.Spells
import com.example.kotlincomposefirstapp.wizards.models.Wizard
import com.example.kotlincomposefirstapp.wizards.wizards_api_service.RetrofitMoviesInstance

class WizardsRepository {
    suspend fun getAllCharacters() : List<Wizard> {
        return RetrofitMoviesInstance.api.getAllCharacters()
    }

    suspend fun getAllSpells() : List<Spells> {
        return RetrofitMoviesInstance.api.getAllSpells()
    }
}