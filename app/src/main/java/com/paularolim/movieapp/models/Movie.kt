package com.paularolim.movieapp.models

import com.google.gson.annotations.SerializedName

data class Movie(
    val title: String,
    @SerializedName("backdrop_path")
    val backdropImage: String,
    @SerializedName("poster_path")
    val posterImage: String,
    val overview: String,
    @SerializedName("genres")
    val categories: List<Category>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("runtime")
    val duration: String
)
