package com.example.kotlincomposefirstapp.wizards.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun WizardsScreen(
    onClickWizards: () -> Unit,
    onClickSpells: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp),
            horizontalAlignment =
            Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ButtonWithColor(
                text= "Wizards List",
                onClickItem = onClickWizards,
                color = Color.Gray
            )
            ButtonWithColor(
                text= "Spells List",
                onClickItem = onClickSpells,
                color = Color.Blue
            )
        }
    }
}

@Composable
fun ButtonWithColor(
    text: String,
    onClickItem: () -> Unit,
    color: Color,
) {
    Button(
        onClick = { onClickItem() },
        colors = ButtonDefaults.buttonColors(color)
    )
    {
        Text(text = text, color = Color.White)
    }
}