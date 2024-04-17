package com.example.kotlincomposefirstapp.wizards.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlincomposefirstapp.wizards.models.Spells

class SpellViewModel : ViewModel() {
    var spell by mutableStateOf<Spells?>(null)
        private set

    fun addSpell(newSpell: Spells){
        spell = newSpell
    }
}