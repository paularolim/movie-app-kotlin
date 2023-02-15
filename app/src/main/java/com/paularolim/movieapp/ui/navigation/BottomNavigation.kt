package com.paularolim.movieapp.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.paularolim.movieapp.R

sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_baseline_home_24, "home")
    object Search : BottomNavItem("Search", R.drawable.ic_baseline_search_24, "search")
}

@SuppressLint("RestrictedApi")
@Composable
fun BottomNavigation(navController: NavController, bottomBarState: MutableState<Boolean>) {
    val items = listOf(BottomNavItem.Home, BottomNavItem.Search)

    AnimatedVisibility(visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp, vertical = 12.dp)
            ) {
                BottomNavigation(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(48.dp))
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route

                    items.forEach { item ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    painter = painterResource(item.icon),
                                    contentDescription = ""
                                )
                            },
                            label = { Text(text = item.title) },
                            selected = item.route == currentRoute,
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        inclusive = true
                                    }
                                    launchSingleTop = true
                                }
                            }
                        )

                    }
                }
            }
        })
}
