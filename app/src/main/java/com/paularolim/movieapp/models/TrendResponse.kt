package com.paularolim.movieapp.models

import com.google.gson.annotations.SerializedName

data class TrendResponse(
    val page: Int,
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
