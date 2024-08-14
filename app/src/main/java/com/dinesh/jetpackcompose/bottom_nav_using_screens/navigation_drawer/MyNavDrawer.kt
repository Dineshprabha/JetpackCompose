package com.dinesh.jetpackcompose.bottom_nav_using_screens.navigation_drawer

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dinesh.jetpackcompose.bottom_nav_using_screens.HomeScreen
import com.dinesh.jetpackcompose.bottom_nav_using_screens.NotificationScreen
import com.dinesh.jetpackcompose.bottom_nav_using_screens.ProfileScreen
import com.dinesh.jetpackcompose.bottom_nav_using_screens.Screens
import com.dinesh.jetpackcompose.bottom_nav_using_screens.SearchScreen
import com.dinesh.jetpackcompose.ui.theme.GreenJC
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavDrawer() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .background(GreenJC)
                        .fillMaxWidth()
                        .height(150.dp)
                ) {

                }

                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Home", color = GreenJC) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home",
                            tint = GreenJC
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.screens) {
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(
                    label = { Text(text = "Search", color = GreenJC) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = GreenJC
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Search.screens) {
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(
                    label = { Text(text = "Notification", color = GreenJC) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notification",
                            tint = GreenJC
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Notification.screens) {
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(
                    label = { Text(text = "Profile", color = GreenJC) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Profile",
                            tint = GreenJC
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screens) {
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(
                    label = { Text(text = "Logout", color = GreenJC) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Logout",
                            tint = GreenJC
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Logout successfuly..", Toast.LENGTH_SHORT).show()
                    })


            }
        }
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(title = { Text(text = "My App") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = GreenJC,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                Icons.Rounded.Menu, contentDescription = "menu Button"
                            )
                        }
                    }

                )
            }
        ) {
            NavHost(navController = navigationController, startDestination = Screens.Home.screens) {
                composable(Screens.Home.screens) { HomeScreen() }
                composable(Screens.Search.screens) { SearchScreen() }
                composable(Screens.Notification.screens) { NotificationScreen() }
                composable(Screens.Profile.screens) { ProfileScreen() }
            }
        }
    }
}