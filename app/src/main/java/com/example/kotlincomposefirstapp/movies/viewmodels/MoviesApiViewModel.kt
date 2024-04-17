package com.example.kotlincomposefirstapp.movies.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincomposefirstapp.movies.models.Wizard
import com.example.kotlincomposefirstapp.movies.repositories.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MoviesApiViewModel : ViewModel() {
    // UI state exposed to the UI
    private val _moviesState = MutableStateFlow(MoviesViewModelUiState())
    private val repository = MoviesRepository()
    // Backing property to avoid state updates from other classes
    val moviesState: StateFlow<MoviesViewModelUiState> = _moviesState.asStateFlow()

    init {
        launchAPI()
    }

    private fun launchAPI() {
        viewModelScope.launch {
            try {
                val result = repository.getAllCharacters()
                _moviesState.value = MoviesViewModelUiState(
                    movies = result
                )
            } catch (e: Exception) {
                _moviesState.value = MoviesViewModelUiState(
                    error = e.message
                )
            }
        }
    }
}

data class MoviesViewModelUiState(
    val movies: List<Wizard> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)