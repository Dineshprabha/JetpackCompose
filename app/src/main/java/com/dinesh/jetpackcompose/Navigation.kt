package com.dinesh.jetpackcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dinesh.jetpackcompose.calculator.Calculator
import com.dinesh.jetpackcompose.login_signup.screens.LoginScreen
import com.dinesh.jetpackcompose.weatherapp.WeatherPage
import com.dinesh.jetpackcompose.weatherapp.WeatherViewModel

@Composable
fun MyNavigation(viewModel: WeatherViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Weather, builder = {
        composable(Routes.Weather){
            WeatherPage(viewModel)
        }

    })
}