package com.paularolim.movieapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paularolim.movieapp.models.Movie
import com.paularolim.movieapp.services.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel : ViewModel() {
    private val service = RetrofitService()

    var searchText by mutableStateOf("")
        private set

    private val _movies = MutableLiveData<List<Movie>>()
    private val _loading = MutableLiveData<Boolean>()
    private val _error = MutableLiveData<String>()

    val movies: LiveData<List<Movie>> get() = _movies
    val loading: LiveData<Boolean> get() = _loading
    val error: LiveData<String> get() = _error

    fun onSearchTextChange(text: String) {
        searchText = text
    }

    fun fetchSearch() {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.postValue(true)
            _error.postValue("")

            try {
                val response = service.getSearch(searchText)

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        _movies.postValue(response.body()?.results ?: emptyList())
                        Log.i("SearchViewModel", response.body().toString())
                    }
                } else {
                    _error.postValue("Error on request")
                    Log.e("SearchViewModel", "Error on request")
                }
            } catch (requestException: Exception) {
                _error.postValue(requestException.message.toString())
                Log.e("SearchViewModel", requestException.message.toString())
            }

            _loading.postValue(false)
        }
    }
}