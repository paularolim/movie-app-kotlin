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
import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MovieDataHeader(modifier: Modifier = Modifier, movie: Movie) {
    val category1: Category? =
        if (movie.categories.isNotEmpty() && movie.categories.getOrNull(0) != null) movie.categories[0] else null
    val category2: Category? =
        if (movie.categories.isNotEmpty() && movie.categories.getOrNull(1) != null) movie.categories[1] else null
    val category =
        if (category1 != null && category2 != null) "${category1.name} / ${category2.name}" else ""

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
    val movie = Movie(
        title = "Movie title",
        backdropImage = "https://image.tmdb.org/t/p/original/kuf6dutpsT0vSVehic3EZIqkOBt.jpg",
        posterImage = "https://image.tmdb.org/t/p/original/kuf6dutpsT0vSVehic3EZIqkOBt.jpg",
        overview = "Lorem ipsum.",
        categories = listOf(Category("1", "Category 1"), Category("2", "Category 2")),
        releaseDate = "2022-12-07",
        duration = "203"
    )
    MovieDataHeader(movie = movie)
}