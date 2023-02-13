package com.paularolim.movieapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TrendViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TrendViewModel::class.java)) {
            TrendViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}