package com.paularolim.movieapp.ui.mocks

import com.paularolim.movieapp.models.Category
import com.paularolim.movieapp.models.Movie

val movieMock = Movie(
    id = "1234",
    title = "Movie title",
    backdropImage = "https://image.tmdb.org/t/p/original/kuf6dutpsT0vSVehic3EZIqkOBt.jpg",
    posterImage = "https://image.tmdb.org/t/p/original/kuf6dutpsT0vSVehic3EZIqkOBt.jpg",
    overview = "Lorem ipsum.",
    categories = listOf(Category("1", "Category 1"), Category("2", "Category 2")),
    releaseDate = "2022-12-07",
    duration = "203"
)