package com.example.kotlincomposefirstapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlincomposefirstapp.viewmodels.UserViewModel
import com.example.kotlincomposefirstapp.views.DetailUserScreen
import com.example.kotlincomposefirstapp.views.HomeScreenView
import com.example.kotlincomposefirstapp.views.MoviesScreen
import com.example.kotlincomposefirstapp.views.NewsScreen

@Composable
fun HomeNavGraph(
    navController: NavHostController
) {
    val userViewModel: UserViewModel = viewModel()

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreenView(
                onClickItem = {
                    navController.navigate(route = DetailsScreen.Detail.route)
                },
                userViewModel = userViewModel
            )
        }
        composable(route = BottomBarScreen.News.route) {
            NewsScreen()
        }
        composable(route = BottomBarScreen.Movies.route) {
            MoviesScreen()
        }
        composable(route = DetailsScreen.Detail.route) {
            DetailUserScreen(userViewModel = userViewModel)
        }
    }
}

sealed class DetailsScreen(val route: String) {
    data object Detail : DetailsScreen(route = "DETAIL-USER")
}