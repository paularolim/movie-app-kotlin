package com.paularolim.movieapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {
    Column() {
        Text(text = "Home")
        Button(onClick = { navController.navigate("movie/315162") }) {
            Text(text = "Puss on Boots")
        }
        Button(onClick = { navController.navigate("movie/536554") }) {
            Text(text = "M3GAN")
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}