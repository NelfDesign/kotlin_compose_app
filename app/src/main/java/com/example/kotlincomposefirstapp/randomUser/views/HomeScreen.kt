package com.example.kotlincomposefirstapp.randomUser.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlincomposefirstapp.navigation.BottomBar
import com.example.kotlincomposefirstapp.navigation.navgraph.HomeNavGraph
import com.example.kotlincomposefirstapp.randomUser.viewmodels.APIViewModel
import com.example.kotlincomposefirstapp.randomUser.viewmodels.UserViewModel

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            HomeNavGraph(navController = navController)
        }
    }
}

@Composable
fun HomeScreenView(
    viewModel: APIViewModel = viewModel(),
    userViewModel: UserViewModel,
    onClickItem: () -> Unit,
) {
    val state = viewModel.uiState.collectAsState()

    if (state.value.loading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.size(200.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    color = Color.Blue,
                    strokeWidth = 3.dp
                )
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp)
        ) {
            items(
                items = state.value.users,
                /**
                 * Use key param to define unique keys representing the items in a mutable list,
                 * instead of using the default key (list position). This prevents unnecessary
                 * recompositions.
                 */
                key = { task -> task.cell },
                itemContent = { item ->
                    UserItem(user = item, onClick = {
                        userViewModel.addUser(item)
                        onClickItem()
                    })
                })
        }

    }
}