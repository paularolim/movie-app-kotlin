package com.paularolim.movieapp.ui.screens.movie

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paularolim.movieapp.R

@Composable
fun MovieError(tryAgain: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_error_outline_24),
            contentDescription = "Error icon",
            tint = MaterialTheme.colors.error,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Uh oh.", fontSize = 24.sp, fontWeight = FontWeight(700))
        Text(text = "Something wierd happened.")
        Text(text = "Keep calm and try again.")
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { tryAgain() },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.error)
        ) {
            Text(text = "Try again")
        }
    }
}

@Preview
@Composable
private fun MovieErrorPreview() {
    fun tryAgain() {}
    MovieError(::tryAgain)
}