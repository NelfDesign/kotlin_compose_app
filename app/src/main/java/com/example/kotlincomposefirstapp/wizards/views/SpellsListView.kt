package com.example.kotlincomposefirstapp.wizards.views

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
import com.example.kotlincomposefirstapp.wizards.viewmodels.SpellViewModel
import com.example.kotlincomposefirstapp.wizards.viewmodels.SpellsViewModel

@Composable
fun SpellsListView(
    viewModel: SpellsViewModel = viewModel(),
    spellViewModel: SpellViewModel,
    onClickItem: () -> Unit,
) {
    val state = viewModel.spellsState.collectAsState()
    val spells = state.value.spells

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(spells.size) { item ->
                    SpellItem(spell = spells[item], onClick = {
                        spellViewModel.addSpell(spells[item])
                        onClickItem()
                    })
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}