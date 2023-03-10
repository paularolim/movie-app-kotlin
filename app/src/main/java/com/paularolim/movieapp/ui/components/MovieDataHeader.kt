package com.paularolim.movieapp.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.paularolim.movieapp.functions.formatDuration
import com.paularolim.movieapp.functions.getYearFromDate
import com.paularolim.movieapp.models.Category
import com.paularolim.movieapp.models.Movie
import com.paularolim.movieapp.ui.mocks.movieMock

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MovieDataHeader(modifier: Modifier = Modifier, movie: Movie) {
    val category = movie.categories.take(2).joinToString(" / ") { it.name }

    val year = getYearFromDate(movie.releaseDate)
    val duration = formatDuration(movie.duration)

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
                    text = category,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(300)
                )
                Text(
                    text = "$year - $duration",
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

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun MovieDataHeaderPreview() {
    MovieDataHeader(movie = movieMock)
}