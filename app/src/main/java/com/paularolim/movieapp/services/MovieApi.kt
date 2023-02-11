package com.paularolim.movieapp.services

import com.paularolim.movieapp.models.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val apikey = "xxxxx"
private const val language = "en-US"

interface MovieApi {
    @GET("movie/{id}?api_key=${apikey}&language=${language}")
    suspend fun getMovie(@Path("id") id: String): Response<Movie>
}