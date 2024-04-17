package com.example.kotlincomposefirstapp.movies.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlincomposefirstapp.movies.viewmodels.MoviesApiViewModel
import com.example.kotlincomposefirstapp.movies.viewmodels.WizardViewModel

@Composable
fun MoviesScreen(
    viewModel: MoviesApiViewModel = viewModel(),
    wizardViewModel: WizardViewModel,
    onClickItem: () -> Unit,
) {
    val state = viewModel.moviesState.collectAsState()
    val wizards = state.value.movies

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(wizards.size) { item ->
                    WizardItem(wizard = wizards[item], onClick = {
                        wizardViewModel.addWizard(wizards[item])
                        onClickItem()
                    })
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}