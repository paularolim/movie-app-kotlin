package com.paularolim.movieapp.services

import com.paularolim.movieapp.models.Movie
import com.paularolim.movieapp.models.TrendResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale

class RetrofitService(private val language: String = Locale.getDefault().toLanguageTag()) {
    private val api: MovieApi = Retrofit
        .Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieApi::class.java)

    suspend fun getMovie(id: String): Response<Movie> = api.getMovie(id, language)

    suspend fun getTrend(): Response<TrendResponse> = api.getTrend(language)
}