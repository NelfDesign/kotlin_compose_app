package com.example.kotlincomposefirstapp.wizards.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincomposefirstapp.wizards.models.Wizard
import com.example.kotlincomposefirstapp.wizards.repositories.WizardsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WizardsApiViewModel : ViewModel() {
    // UI state exposed to the UI
    private val _wizardsState = MutableStateFlow(WizardsViewModelUiState())
    private val repository = WizardsRepository()
    // Backing property to avoid state updates from other classes
    val wizardState : StateFlow<WizardsViewModelUiState> = _wizardsState.asStateFlow()

    init {
        launchAPI()
    }

    private fun launchAPI() {
        viewModelScope.launch {
            try {
                val result = repository.getAllCharacters()
                _wizardsState.value = WizardsViewModelUiState(
                    movies = result
                )
            } catch (e: Exception) {
                _wizardsState.value = WizardsViewModelUiState(
                    error = e.message
                )
            }
        }
    }
}

data class WizardsViewModelUiState(
    val movies: List<Wizard> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)