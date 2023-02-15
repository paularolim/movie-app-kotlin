package com.paularolim.movieapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.paularolim.movieapp.ui.screens.home.HomeScreen
import com.paularolim.movieapp.ui.screens.movie.MovieScreen
import com.paularolim.movieapp.ui.screens.search.SearchScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = "movie/{id}") { backStackEntry ->
            MovieScreen(
                id = backStackEntry.arguments?.getString("id") ?: "",
                goBack = { navController.popBackStack() }
            )
        }
        composable(BottomNavItem.Search.route) {
            SearchScreen()
        }
    }
}