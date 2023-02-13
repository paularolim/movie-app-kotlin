package com.paularolim.movieapp.ui.screens.home.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.paularolim.movieapp.viewmodels.TrendViewModel
import com.paularolim.movieapp.viewmodels.TrendViewModelFactory

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TrendList(
    viewModel: TrendViewModel = viewModel(factory = TrendViewModelFactory()),
    navController: NavController
) {
    val movies by viewModel.movies.observeAsState()
    val loading by viewModel.loading.observeAsState()
    val error by viewModel.error.observeAsState()

    fun tryAgain() {
        viewModel.fetchTrend()
    }

    if (loading == true) {
        TrendLoading()
    } else if (error?.isNotEmpty() == true && error?.isNotBlank() == true) {
        TrendError(tryAgain = { tryAgain() })
    } else if (movies?.isNotEmpty() == true) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Tendências", modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            )
            LazyRow(contentPadding = PaddingValues(horizontal = 24.dp), content = {
                itemsIndexed(movies!!) { index, movie ->
                    TrendCard(
                        movie = movie,
                        onClickCard = { navController.navigate("movie/${movie.id}") })
                    if (index < 4)
                        Spacer(modifier = Modifier.width(12.dp))
                }
            })
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun TrendListPreview() {
    val navController = rememberNavController()
    TrendList(navController = navController)
}