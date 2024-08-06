package com.dinesh.jetpackcompose.bottom_nav_bar

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val title : String,
    val route : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews : Boolean,
    val badges : Int
)
