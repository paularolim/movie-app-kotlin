package com.paularolim.movieapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            MovieViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}