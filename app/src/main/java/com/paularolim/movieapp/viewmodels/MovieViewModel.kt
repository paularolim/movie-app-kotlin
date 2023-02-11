package com.paularolim.movieapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paularolim.movieapp.models.Movie
import com.paularolim.movieapp.services.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel : ViewModel() {
    private val service = RetrofitService()
    private val _movie = MutableLiveData<Movie>()
    private val _loading = MutableLiveData<Boolean>()
    private val _error = MutableLiveData<String>()

    val movie: LiveData<Movie> get() = _movie
    val loading: LiveData<Boolean> get() = _loading
    val error: LiveData<String> get() = _error

    fun fetchMovieDetails(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.postValue(true)
            _error.postValue("")

            val response = service.getMovie(id = id)

            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    _movie.postValue(response.body())
                }
            } else {
                _error.postValue("Error on request")
                Log.e("MovieViewModel", "Error on request")
            }

            _loading.postValue(false)
        }
    }
}