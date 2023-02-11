package com.paularolim.movieapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paularolim.movieapp.ui.components.MovieHeader

@Composable
fun MovieScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)) {
        MovieHeader()
    }
}

@Preview
@Composable
private fun MovieScreenPreview() {
    MovieScreen()
}