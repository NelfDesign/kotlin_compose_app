package com.example.kotlincomposefirstapp.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.kotlincomposefirstapp.movies.models.Wizard

@Composable
fun WizardItem(wizard: Wizard, onClick: () -> Unit = {}) {
    Card(
        onClick = { onClick() },
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                Column(
                    horizontalAlignment =
                    Alignment.CenterHorizontally
                ) {
                    ProfileImageWizard(
                        url = wizard.image,
                    )
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = wizard.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = wizard.house,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun ProfileImageWizard(
    url: String,
) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(70.dp)
            .clip(
                shape = RoundedCornerShape(50)
            )
    )
}