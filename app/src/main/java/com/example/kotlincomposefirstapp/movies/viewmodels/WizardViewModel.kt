package com.example.kotlincomposefirstapp.movies.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlincomposefirstapp.movies.models.Wizard

class WizardViewModel : ViewModel() {
    var wizard by mutableStateOf<Wizard?>(null)
        private set

    fun addWizard(newWizard: Wizard){
        wizard = newWizard
    }
}