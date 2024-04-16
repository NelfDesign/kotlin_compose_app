package com.example.kotlincomposefirstapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.kotlincomposefirstapp.models.User

@Composable
fun UserItem(
    user: User,
    onClick: () -> Unit = {},
) {
    Card(
        onClick = { onClick() },
        modifier = Modifier.padding(5.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                ProfileImage(
                    drawableResource = user.picture.medium,
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "${user.name.last} ${user.name.first}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = user.email,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileImage(
    drawableResource: String,
) {
    Image(
        painter = rememberAsyncImagePainter(drawableResource),
        contentDescription = null,
        modifier = Modifier
            .size(70.dp)
            .clip(
                shape = RoundedCornerShape(50)
            )
    )
}

@Preview
@Composable
fun ProfileImagePreview() {
    ProfileImage("https://randomuser.me/api/portraits/men/75.jpg")
}