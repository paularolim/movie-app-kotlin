package com.paularolim.movieapp.ui.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paularolim.movieapp.modifiers.shimmerEffect

@Composable
fun TrendLoading() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(horizontal = 24.dp)
                .height(20.dp)
                .clip(RoundedCornerShape(8.dp))
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(contentPadding = PaddingValues(horizontal = 24.dp), content = {
            items(5) { index ->
                TrendCardLoading()
                if (index < 4)
                    Spacer(modifier = Modifier.width(12.dp))
            }
        })
    }
}

@Preview
@Composable
private fun TrendLoadingPreview() {
    TrendLoading()
}