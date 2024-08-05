package com.dinesh.jetpackcompose

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dinesh.jetpackcompose.calculator.Calculator
import com.dinesh.jetpackcompose.login_signup.screens.LoginScreen
import com.dinesh.jetpackcompose.todo.ToDoViewModel
import com.dinesh.jetpackcompose.todo.TodoListPage
import com.dinesh.jetpackcompose.weatherapp.WeatherPage
import com.dinesh.jetpackcompose.weatherapp.WeatherViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyNavigation(viewModel: ToDoViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Todo, builder = {
        composable(Routes.Todo){
            TodoListPage(viewModel)
        }

    })
}