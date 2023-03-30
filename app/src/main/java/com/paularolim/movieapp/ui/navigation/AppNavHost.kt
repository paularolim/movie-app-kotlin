package com.paularolim.movieapp.ui.navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.paularolim.movieapp.ui.components.Header

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val topBarState = rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route) {
        "home" -> {
            bottomBarState.value = true
            topBarState.value = true
        }
        "search" -> {
            bottomBarState.value = true
            topBarState.value = true
        }
        "movie/{id}" -> {
            bottomBarState.value = false
            topBarState.value = false
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = navController, bottomBarState = bottomBarState
            )
        },
        topBar = { Header(topBarState = topBarState) }
    ) {
        NavigationGraph(navController = navController)
    }
}