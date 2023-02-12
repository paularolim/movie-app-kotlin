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
import coil.compose.rememberAsyncImagePainter
import com.paularolim.movieapp.R
import com.paularolim.movieapp.models.Movie

@Composable
fun MovieDataHeader(modifier: Modifier = Modifier, movie: Movie) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .composed { modifier }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(movie.posterImage),
                contentDescription = "Movie poster",
                modifier = Modifier
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Column(modifier = Modifier.padding(start = 12.dp)) {
                Text(
                    text = movie.title,
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
            text = movie.overview,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(300)
        )
    }
}

@Preview
@Composable
private fun MovieDataHeaderPreview() {
    val movie = Movie(
        title = "Movie title",
        backdropImage = "https://image.tmdb.org/t/p/original/kuf6dutpsT0vSVehic3EZIqkOBt.jpg",
        posterImage = "https://image.tmdb.org/t/p/original/kuf6dutpsT0vSVehic3EZIqkOBt.jpg",
        overview = "Lorem ipsum."
    )
    MovieDataHeader(movie = movie)
}