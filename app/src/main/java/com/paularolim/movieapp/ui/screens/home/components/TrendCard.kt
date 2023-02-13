package com.paularolim.movieapp.ui.screens.home.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.paularolim.movieapp.functions.getYearFromDate
import com.paularolim.movieapp.models.Movie
import com.paularolim.movieapp.ui.mocks.movieMock

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TrendCard(movie: Movie, onClickCard: () -> Unit) {
    val image = "https://image.tmdb.org/t/p/original${movie.posterImage}"

    Column(modifier = Modifier
        .width(100.dp)
        .clickable { onClickCard() }) {
        Image(
            painter = rememberAsyncImagePainter(image),
            contentDescription = "Movie poster",
            modifier = Modifier
                .width(100.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = movie.title)
        Text(text = getYearFromDate(movie.releaseDate))
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun TrendCardPrivate() {
    TrendCard(movie = movieMock, onClickCard = {})
}