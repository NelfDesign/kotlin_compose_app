package com.example.kotlincomposefirstapp.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlincomposefirstapp.movies.viewmodels.WizardViewModel
import com.example.kotlincomposefirstapp.movies.views.DetailWizardScreen
import com.example.kotlincomposefirstapp.movies.views.MoviesScreen
import com.example.kotlincomposefirstapp.navigation.BottomBarScreen
import com.example.kotlincomposefirstapp.navigation.Graph
import com.example.kotlincomposefirstapp.randomUser.viewmodels.UserViewModel
import com.example.kotlincomposefirstapp.randomUser.views.DetailUserScreen
import com.example.kotlincomposefirstapp.randomUser.views.HomeScreenView

@Composable
fun HomeNavGraph(
    navController: NavHostController
) {
    val userViewModel: UserViewModel = viewModel()
    val wizardViewModel: WizardViewModel = viewModel()

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
        composable(route = BottomBarScreen.Movies.route) {
            MoviesScreen(
                onClickItem = {
                    navController.navigate(route = DetailsScreen.WizardDetail.route)
                },
                wizardViewModel = wizardViewModel
            )
        }
        composable(route = DetailsScreen.Detail.route) {
            DetailUserScreen(userViewModel = userViewModel)
        }
        composable(route = DetailsScreen.WizardDetail.route) {
            DetailWizardScreen(wizardViewModel = wizardViewModel)
        }
    }
}

sealed class DetailsScreen(val route: String) {
    data object Detail : DetailsScreen(route = "DETAIL-USER")
    data object WizardDetail : DetailsScreen(route = "DETAIL-WIZARD")
}