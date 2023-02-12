package com.paularolim.movieapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Surface
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paularolim.movieapp.ui.screens.HomeScreen
import com.paularolim.movieapp.ui.screens.movie.MovieScreen
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val startDestination = "home"

    Surface {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }

        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                Drawer(onDestinationClicked = { route ->
                    scope.launch {
                        drawerState.close()
                    }
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                })
            }) {

            NavHost(navController = navController, startDestination = startDestination) {
                composable(route = "home") {
                    HomeScreen(navController)
                }
                composable(route = "movie/{id}") { backStackEntry ->
                    MovieScreen(
                        id = backStackEntry.arguments?.getString("id") ?: "",
                        openDrawer = { openDrawer() }
                    )
                }
            }
        }
    }
}