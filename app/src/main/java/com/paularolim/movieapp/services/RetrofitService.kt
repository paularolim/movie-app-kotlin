package com.paularolim.movieapp.services

import com.paularolim.movieapp.models.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    private val api: MovieApi = Retrofit
        .Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieApi::class.java)

    suspend fun getMovie(id: String): Response<Movie> = api.getMovie(id)
}