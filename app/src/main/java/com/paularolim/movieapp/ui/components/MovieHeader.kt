package com.paularolim.movieapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paularolim.movieapp.R

@Composable
fun MovieHeader(openDrawer: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_baseline_menu_24),
            contentDescription = "Menu icon",
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    openDrawer()
                }
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
private fun MovieHeaderPreview() {
    fun openDrawer() {}
    MovieHeader(openDrawer = ::openDrawer)
}