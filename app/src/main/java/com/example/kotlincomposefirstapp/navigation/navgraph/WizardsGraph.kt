package com.example.kotlincomposefirstapp.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kotlincomposefirstapp.navigation.BottomBarScreen
import com.example.kotlincomposefirstapp.navigation.Graph
import com.example.kotlincomposefirstapp.wizards.viewmodels.SpellViewModel
import com.example.kotlincomposefirstapp.wizards.viewmodels.WizardViewModel
import com.example.kotlincomposefirstapp.wizards.views.DetailWizardScreen
import com.example.kotlincomposefirstapp.wizards.views.SpellsListView
import com.example.kotlincomposefirstapp.wizards.views.WizardsScreenView

fun NavGraphBuilder.wizardsNavGraph(
    navController: NavHostController,
    wizardViewModel: WizardViewModel,
    spellViewModel: SpellViewModel
) {
    navigation(
        route = Graph.WIZARDS,
        startDestination = BottomBarScreen.Wizards.route
    ) {
        composable(route = DetailsWizardsScreen.WizardList.route) {
            WizardsScreenView(
                onClickItem = {
                    navController.navigate(route = DetailsWizardsScreen.WizardDetail.route)
                },
                wizardViewModel = wizardViewModel
            )
        }
        composable(route = DetailsWizardsScreen.WizardDetail.route) {
            DetailWizardScreen(wizardViewModel = wizardViewModel)
        }
        composable(route = DetailsWizardsScreen.SpellsList.route) {
            SpellsListView(
                onClickItem = {
                    navController.navigate(route = DetailsWizardsScreen.WizardDetail.route)
                },
                spellViewModel = spellViewModel
            )
        }
    }
}

sealed class DetailsWizardsScreen(val route: String) {
    data object WizardList : DetailsWizardsScreen(route = "LIST-WIZARD")
    data object WizardDetail : DetailsWizardsScreen(route = "DETAIL-WIZARD")
    data object SpellsList : DetailsWizardsScreen(route = "LIST-SPELLS")
}