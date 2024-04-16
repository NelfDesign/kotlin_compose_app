package com.example.kotlincomposefirstapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincomposefirstapp.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class APIViewModel: ViewModel() {
    // UI state exposed to the UI
    private val _uiState = MutableStateFlow(ApiViewModelUiState())
    private val repository = Repository()
    // Backing property to avoid state updates from other classes
    val uiState: StateFlow<ApiViewModelUiState> = _uiState.asStateFlow()

    init {
        launchAPI()
    }

    private fun launchAPI() {
        viewModelScope.launch {
            try {
                println("ici")
                val result = repository.getUserList()
                println("val = ${result}")
               _uiState.value = ApiViewModelUiState(
                    users = result.results
                )
            } catch (e: Exception) {
                println(e.message?: "Erreur inconnue")
            }
        }
    }
}

data class ApiViewModelUiState(
    val users: List<User> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)