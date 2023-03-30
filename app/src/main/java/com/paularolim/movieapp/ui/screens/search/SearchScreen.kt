package com.paularolim.movieapp.ui.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.paularolim.movieapp.ui.screens.search.components.SearchItem
import com.paularolim.movieapp.ui.screens.search.components.SearchItemLoading
import com.paularolim.movieapp.viewmodels.SearchViewModel
import com.paularolim.movieapp.viewmodels.SearchViewModelFactory

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    viewModel: SearchViewModel = viewModel(factory = SearchViewModelFactory()),
    navController: NavController
) {
    val searchText = viewModel.searchText

    val movies by viewModel.movies.observeAsState()
    val loading by viewModel.loading.observeAsState()
    val error by viewModel.error.observeAsState()

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    viewModel.fetchSearch()
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
            ),
            isError = false,
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )

        if (loading == true) {
            LazyColumn(contentPadding = PaddingValues(24.dp), content = {
                itemsIndexed(listOf(1, 2, 3, 4, 5)) { index, _ ->
                    SearchItemLoading()
                    if (index < 5) Spacer(modifier = Modifier.height(24.dp))
                }
            })
        } else if (movies?.isNotEmpty() == true) {
            LazyColumn(contentPadding = PaddingValues(24.dp), content = {
                itemsIndexed(movies!!) { index, item ->
                    SearchItem(
                        movie = item,
                        onClickCard = { navController.navigate("movie/${item.id}") }
                    )
                    if (index < movies!!.size) Spacer(modifier = Modifier.height(24.dp))
                }
            })
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    val navController = rememberNavController()
    SearchScreen(navController = navController)
}