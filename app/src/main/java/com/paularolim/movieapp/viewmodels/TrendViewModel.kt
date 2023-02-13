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

class TrendViewModel : ViewModel() {
    private val service = RetrofitService()

    private val _movies = MutableLiveData<List<Movie>>()
    private val _loading = MutableLiveData<Boolean>()
    private val _error = MutableLiveData<String>()

    val movies: LiveData<List<Movie>> get() = _movies
    val loading: LiveData<Boolean> get() = _loading
    val error: LiveData<String> get() = _error

    init {
        fetchTrend()
    }

    fun fetchTrend() {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.postValue(true)
            _error.postValue("")

            try {
                val response = service.getTrend()

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        _movies.postValue(response.body()?.results?.take(5) ?: emptyList<Movie>())
                    }
                } else {
                    _error.postValue("Error on request")
                    Log.e("TrendViewModel", "Error on request")
                }

            } catch (exception: Exception) {
                _error.postValue(exception.message.toString())
                Log.e("TrendViewModel", exception.message.toString())
            }

            _loading.postValue(false)
        }
    }
}