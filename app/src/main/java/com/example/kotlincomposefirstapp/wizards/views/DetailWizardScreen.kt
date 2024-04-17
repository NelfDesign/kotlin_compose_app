package com.example.kotlincomposefirstapp.wizards.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import coil.compose.rememberAsyncImagePainter
import com.example.kotlincomposefirstapp.wizards.viewmodels.WizardViewModel

@Composable
fun DetailWizardScreen(
    wizardViewModel: WizardViewModel
) {
    val wizard = wizardViewModel.wizard

    Column(
        modifier = Modifier
            .fillMaxSize()
            .semantics { contentDescription = "Wizard Screen" },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ImageWizardDetail(url = wizard!!.image)
    }
}

@Composable
fun ImageWizardDetail(
    url: String,
) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
            .fillMaxSize()

    )
}