package com.paularolim.movieapp.ui.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paularolim.movieapp.ui.mocks.movieMock
import com.paularolim.movieapp.ui.screens.search.components.SearchItem

@Composable
fun SearchScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(contentPadding = PaddingValues(24.dp), content = {
            itemsIndexed(listOf(1, 2, 3, 4, 5)) { index, item ->
                SearchItem(movie = movieMock)
                if (index < 5) Spacer(modifier = Modifier.height(24.dp))
            }
        })
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    SearchScreen()
}