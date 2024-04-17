package com.example.kotlincomposefirstapp.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlincomposefirstapp.navigation.BottomBarScreen
import com.example.kotlincomposefirstapp.navigation.Graph
import com.example.kotlincomposefirstapp.randomUser.viewmodels.UserViewModel
import com.example.kotlincomposefirstapp.randomUser.views.DetailUserScreen
import com.example.kotlincomposefirstapp.randomUser.views.HomeScreenView
import com.example.kotlincomposefirstapp.wizards.viewmodels.SpellViewModel
import com.example.kotlincomposefirstapp.wizards.viewmodels.WizardViewModel
import com.example.kotlincomposefirstapp.wizards.views.WizardsScreen

@Composable
fun HomeNavGraph(
    navController: NavHostController
) {
    val userViewModel: UserViewModel = viewModel()
    val wizardViewModel: WizardViewModel = viewModel()
    val spellViewModel: SpellViewModel = viewModel()

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
        composable(route = BottomBarScreen.Wizards.route) {
            WizardsScreen(
                onClickWizards = {
                    navController.navigate(route = DetailsWizardsScreen.WizardList.route)
                },
                onClickSpells = {
                    navController.navigate(route = DetailsWizardsScreen.SpellsList.route)
                }
            )
        }
        composable(route = DetailsScreen.Detail.route) {
            DetailUserScreen(userViewModel = userViewModel)
        }
        wizardsNavGraph(
            navController = navController,
            wizardViewModel = wizardViewModel,
            spellViewModel = spellViewModel
        )
    }
}

sealed class DetailsScreen(val route: String) {
    data object Detail : DetailsScreen(route = "DETAIL-USER")
}