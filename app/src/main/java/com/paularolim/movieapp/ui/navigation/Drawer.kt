package com.paularolim.movieapp.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

sealed class DrawerScreens(val title: String, val route: String) {
    object Home : DrawerScreens("Home", "home")
}

private val screens = listOf(
    DrawerScreens.Home
)

@Composable
fun Drawer(onDestinationClicked: (route: String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 24.dp)
    ) {
        screens.forEach { screen ->
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = screen.title,
                modifier = Modifier.clickable { onDestinationClicked(screen.route) })
        }
    }
}

@Preview
@Composable
private fun DrawerPreview() {
    fun onDestinationClicked(route: String) {}
    Drawer(::onDestinationClicked)
}