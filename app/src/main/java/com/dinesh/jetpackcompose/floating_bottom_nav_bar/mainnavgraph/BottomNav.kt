package com.dinesh.jetpackcompose.floating_bottom_nav_bar.mainnavgraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.dinesh.jetpackcompose.R
import com.dinesh.jetpackcompose.floating_bottom_nav_bar.Screen

sealed class BottomNav(
    val activeIcon: Int,
    val disableIcon: Int,
    val title: String,
    val route: String
){
    data object Screen1 : BottomNav(
        activeIcon = R.drawable.baseline_delete_24,
        disableIcon = R.drawable.baseline_delete_24,
        title = "Home",
        route = Screen.Screen1.route
    )

    /**
     * Screen 2 navigation item.
     */
    data object Screen2 : BottomNav(
        activeIcon = R.drawable.baseline_delete_24,
        disableIcon = R.drawable.baseline_delete_24,
        title = "Screen 2",
        route = Screen.Screen2.route
    )

    /**
     * Screen 3 navigation item.
     */
    data object Screen3 : BottomNav(
        activeIcon = R.drawable.baseline_delete_24,
        disableIcon = R.drawable.baseline_delete_24,
        title = "Screen 3",
        route = Screen.Screen3.route
    )

    /**
     * Screen 4 navigation item.
     */
    data object Screen4 : BottomNav(
        activeIcon = R.drawable.baseline_delete_24,
        disableIcon = R.drawable.baseline_delete_24,
        title = "Screen 4",
        route = Screen.Screen4.route
    )
}