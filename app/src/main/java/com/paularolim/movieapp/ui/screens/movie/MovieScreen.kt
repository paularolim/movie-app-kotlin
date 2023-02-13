package com.paularolim.movieapp.ui.screens.movie

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.paularolim.movieapp.models.Movie
import com.paularolim.movieapp.ui.components.MovieBackdrop
import com.paularolim.movieapp.ui.components.MovieDataHeader
import com.paularolim.movieapp.ui.components.MovieHeader
import com.paularolim.movieapp.viewmodels.MovieViewModel
import com.paularolim.movieapp.viewmodels.MovieViewModelFactory

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MovieScreen(
    id: String,
    openDrawer: () -> Unit,
    viewModel: MovieViewModel = viewModel(factory = MovieViewModelFactory())
) {
    val movieResponse by viewModel.movie.observeAsState()
    val loading by viewModel.loading.observeAsState()
    val error by viewModel.error.observeAsState()

    val movie = Movie(
        id = movieResponse?.id ?: "N/A",
        title = movieResponse?.title ?: "N/A",
        backdropImage = "https://image.tmdb.org/t/p/original${movieResponse?.backdropImage}",
        posterImage = "https://image.tmdb.org/t/p/original${movieResponse?.posterImage}",
        overview = movieResponse?.overview ?: "N/A",
        categories = movieResponse?.categories ?: listOf(),
        releaseDate = movieResponse?.releaseDate ?: "",
        duration = movieResponse?.duration ?: ""
    )

    fun tryAgain() {
        viewModel.fetchMovieDetails(id)
    }

    LaunchedEffect(true) {
        viewModel.fetchMovieDetails(id)
    }

    if (loading == true) {
        MovieLoading()
    } else if (error?.isNotBlank() == true && error?.isNotEmpty() == true) {
        MovieError(tryAgain = { tryAgain() })
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            Box(modifier = Modifier) {
                MovieBackdrop(backdropImage = movie.backdropImage)
                MovieHeader(openDrawer = { openDrawer() })
            }
            Column(modifier = Modifier.offset(y = -(75.dp))) {
                MovieDataHeader(modifier = Modifier.padding(horizontal = 24.dp), movie = movie)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun MovieScreenPreview() {
    fun openDrawer() {}
    MovieScreen(id = "315162", openDrawer = ::openDrawer)
}