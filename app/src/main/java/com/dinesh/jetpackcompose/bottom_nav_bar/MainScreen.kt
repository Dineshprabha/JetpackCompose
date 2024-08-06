package com.dinesh.jetpackcompose.bottom_nav_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var selected by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
            .background(Color.Green),
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = index == selected,
                        onClick = {
                            selected = index
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (navItem.badges != 0) {
                                        Badge {
                                            Text(text = navItem.badges.toString())
                                        }
                                    } else if (navItem.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (index == selected) navItem.selectedIcon else navItem.unselectedIcon,
                                    contentDescription = navItem.title
                                )

                            }
                        },

                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
        containerColor = Color.Gray
    ) {
        val padding = it
    }

}

val bottomNavItems = listOf(
    NavItem(
        title = "Home",
        route = "home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
        badges = 0
    ),
    NavItem(
        title = "Posts",
        route = "posts",
        selectedIcon = Icons.Filled.Email,
        unselectedIcon = Icons.Outlined.MailOutline,
        hasNews = false,
        badges = 0
    ),
    NavItem(
        title = "Notifications",
        route = "notifications",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        hasNews = true,
        badges = 5
    ),
    NavItem(
        title = "Profile",
        route = "profile",
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle,
        hasNews = true,
        badges = 0
    ),
)




