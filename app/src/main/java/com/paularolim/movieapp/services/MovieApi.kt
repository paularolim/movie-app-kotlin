package com.paularolim.movieapp.services

import com.paularolim.movieapp.BuildConfig
import com.paularolim.movieapp.models.Movie
import com.paularolim.movieapp.models.TrendResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val apikey = BuildConfig.API_KEY

interface MovieApi {
    @GET("movie/{id}?api_key=${apikey}")
    suspend fun getMovie(
        @Path("id") id: String,
        @Query("language") language: String
    ): Response<Movie>

    @GET("trending/movie/day?api_key=${apikey}")
    suspend fun getTrend(@Query("language") language: String): Response<TrendResponse>
}