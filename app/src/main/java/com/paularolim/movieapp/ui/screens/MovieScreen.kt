package com.paularolim.movieapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paularolim.movieapp.R
import com.paularolim.movieapp.ui.components.MovieDataHeader
import com.paularolim.movieapp.ui.components.MovieHeader

@Composable
fun MovieScreen(id: String, openDrawer: () -> Unit) {
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
            MovieHeader(openDrawer = { openDrawer() })
        }
        Column(modifier = Modifier.offset(y = -(75.dp))) {
            MovieDataHeader(modifier = Modifier.padding(horizontal = 24.dp))
        }
    }
}

@Preview
@Composable
private fun MovieScreenPreview() {
    fun openDrawer() {}
    MovieScreen(id = "315162", openDrawer = ::openDrawer)
}