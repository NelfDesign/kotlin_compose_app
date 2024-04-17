package com.example.kotlincomposefirstapp.wizards.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlincomposefirstapp.wizards.models.Wizard

class WizardViewModel : ViewModel() {
    var wizard by mutableStateOf<Wizard?>(null)
        private set

    fun addWizard(newWizard: Wizard){
        wizard = newWizard
    }
}