package com.example.kotlincomposefirstapp.wizards.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincomposefirstapp.wizards.models.Spells
import com.example.kotlincomposefirstapp.wizards.repositories.WizardsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SpellsViewModel: ViewModel() {

    // UI state exposed to the UI
    private val _spellsState = MutableStateFlow(SpellsViewModelUiState())
    private val repository = WizardsRepository()
    // Backing property to avoid state updates from other classes
    val spellsState : StateFlow<SpellsViewModelUiState> = _spellsState.asStateFlow()

    init {
        launchAPI()
    }

    private fun launchAPI() {
        viewModelScope.launch {
            try {
                val result = repository.getAllSpells()
                _spellsState.value = SpellsViewModelUiState(
                    spells = result
                )
            } catch (e: Exception) {
                _spellsState.value = SpellsViewModelUiState(
                    error = e.message
                )
            }
        }
    }
}

data class SpellsViewModelUiState(
    val spells: List<Spells> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)