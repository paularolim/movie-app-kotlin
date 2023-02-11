package com.paularolim.movieapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paularolim.movieapp.R

@Composable
fun MovieDataHeader(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(
            Brush.verticalGradient(
                listOf(
                    Color(red = 0xFF, green = 0xFF, blue = 0xFF, alpha = 0x0),
                    MaterialTheme.colors.background
                ), startY = 0f, endY = 120f
            )
        )
        .composed { modifier }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.sampleposter),
                contentDescription = "Movie poster",
                modifier = Modifier
                    .width(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Column(modifier = Modifier.padding(start = 12.dp)) {
                Text(
                    text = "Movie name",
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight(700)
                )
                Text(
                    text = "Movie category / Movie category",
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(300)
                )
                Text(
                    text = "2022 - 2hrs",
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(300)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Puss in Boots discovers that his passion for adventure has taken its toll: He has burned through eight of his nine lives, leaving him with only one life left. Puss sets out on an epic journey to find the mythical Last Wish and restore his nine lives.",
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(300)
        )
    }
}

@Preview
@Composable
private fun MovieDataHeaderPreview() {
    MovieDataHeader()
}