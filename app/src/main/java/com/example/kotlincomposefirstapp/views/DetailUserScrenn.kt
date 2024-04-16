package com.example.kotlincomposefirstapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.kotlincomposefirstapp.models.User
import com.example.kotlincomposefirstapp.viewmodels.UserViewModel

@Composable
fun DetailUserScreen(
    userViewModel: UserViewModel,
) {
    val user = userViewModel.user

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .semantics { contentDescription = "Detail Screen" },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileImageDetail(drawableResource = user?.picture!!.large)
        CardIdentity(user = user)
        CardLocation(user = user)
    }
}

@Composable
fun ProfileImageDetail(
    drawableResource: String,
) {
    Image(
        painter = rememberAsyncImagePainter(drawableResource),
        contentDescription = null,
        modifier = Modifier
            .size(150.dp)
            .clip(
                shape = RoundedCornerShape(50)
            )
    )
}

@Composable
fun CardIdentity(
    user: User
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Cyan.copy(0.5f),
        ),
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Name : ${user.name.last} ${user.name.first}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "email: ${user.email}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Text(
                    text = "Gender: ${user.gender}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Text(
                    text = "Nationality: ${user.nat}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
            }

        }
    }
}

@Composable
fun CardLocation(
    user: User
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Green,
        ),
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "City: ${user.location.city}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Text(
                    text = "Postal code: ${user.location.postcode}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Text(
                    text = "Address: ${user.location.street.number} ${user.location.street.name}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
            }

        }
    }
}