package com.dinesh.jetpackcompose.floating_bottom_nav_bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dinesh.jetpackcompose.floating_bottom_nav_bar.screens.MainScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route,
        route = "main_graph"
    ) {

        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}