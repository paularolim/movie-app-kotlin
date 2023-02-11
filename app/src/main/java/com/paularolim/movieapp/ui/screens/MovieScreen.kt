package com.paularolim.movieapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.paularolim.movieapp.R
import com.paularolim.movieapp.ui.components.MovieHeader

@Composable
fun MovieScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Box(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.samplebackdrop),
                contentDescription = "Backdrop movie",
                contentScale = ContentScale.FillWidth
            )
            MovieHeader()
        }
    }
}

@Preview
@Composable
private fun MovieScreenPreview() {
    MovieScreen()
}