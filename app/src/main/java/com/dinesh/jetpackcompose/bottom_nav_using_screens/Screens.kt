package com.dinesh.jetpackcompose.bottom_nav_using_screens

sealed class Screens(val screens: String) {
    data object Home : Screens("Home")
    data object Search : Screens("Search")
    data object Notification : Screens("Notification")
    data object Profile : Screens("Profile")

}