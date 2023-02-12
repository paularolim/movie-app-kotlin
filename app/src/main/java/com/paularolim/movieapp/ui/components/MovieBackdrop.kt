package com.paularolim.movieapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MovieBackdrop(backdropImage: String) {
    val height = 220.dp

    Box {
        Image(
            painter = rememberAsyncImagePainter(backdropImage),
            contentDescription = "Movie backdrop",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colors.background,
                            Color(red = 0xFF, green = 0xFF, blue = 0xFF, alpha = 0x0),
                            MaterialTheme.colors.background,
                        )
                    )
                )
        ) {}
    }
}

@Preview
@Composable
private fun MovieBackdropPreview() {
    MovieBackdrop("https://image.tmdb.org/t/p/original/xDMIl84Qo5Tsu62c9DGWhmPI67A.jpg")
}