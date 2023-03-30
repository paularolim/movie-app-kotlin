package com.paularolim.movieapp.ui.screens.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.paularolim.movieapp.R
import com.paularolim.movieapp.models.Movie
import com.paularolim.movieapp.ui.mocks.movieMock

@Composable
fun SearchItem(movie: Movie, onClickCard: () -> Unit) {
    val image = "https://image.tmdb.org/t/p/original${movie.posterImage}"

    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClickCard() }) {
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 12.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(image),
                contentDescription = "",
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column() {
                Text(text = movie.title, fontSize = 22.sp, fontWeight = FontWeight(700))
                Text(text = movie.releaseDate, fontSize = 16.sp, fontWeight = FontWeight(200))
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = movie.overview,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    maxLines = 3
                )
            }
        }
    }
}

@Preview
@Composable
private fun SearchItemPreview() {
    SearchItem(movie = movieMock, onClickCard = {})
}