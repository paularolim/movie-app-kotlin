package com.paularolim.movieapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paularolim.movieapp.R

@Composable
fun MovieHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colors.background,
                        Color(red = 0xFF, green = 0xFF, blue = 0xFF, alpha = 0x1A)
                    )
                )
            )
            .padding(top = 12.dp, end = 24.dp, bottom = 24.dp, start = 24.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_baseline_menu_24),
            contentDescription = "Menu icon",
            modifier = Modifier.size(24.dp)
        )

        Text(text = "Movie App", fontSize = 18.sp)

        Icon(
            painter = painterResource(R.drawable.ic_baseline_favorite_border_24),
            contentDescription = "Menu icon",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
fun MovieHeaderPreview() {
    MovieHeader()
}