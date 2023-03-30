package com.paularolim.movieapp.ui.screens.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paularolim.movieapp.modifiers.shimmerEffect

@Composable
fun SearchItemLoading() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Box(modifier = Modifier
                    .width(150.dp)
                    .height(22.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shimmerEffect())
                Spacer(modifier = Modifier.height(2.dp))
                Box(modifier = Modifier
                    .width(70.dp)
                    .height(22.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shimmerEffect())

                Spacer(modifier = Modifier.height(8.dp))

                Box(modifier = Modifier
                    .width(210.dp)
                    .height(18.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shimmerEffect())
                Spacer(modifier = Modifier.height(2.dp))
                Box(modifier = Modifier
                    .width(180.dp)
                    .height(18.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shimmerEffect())
                Spacer(modifier = Modifier.height(2.dp))
                Box(modifier = Modifier
                    .width(120.dp)
                    .height(18.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shimmerEffect())
            }
        }
    }
}

@Preview
@Composable
private fun SearchItemPreview() {
    SearchItemLoading()
}