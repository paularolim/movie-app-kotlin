package com.paularolim.movieapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColors(
    primary = Colors.Dark.primary,
    onPrimary = Colors.Dark.text,
    surface = Colors.Dark.surface,
    background = Colors.Dark.background,

    )

private val LightColorScheme = lightColors(
    primary = Colors.Light.primary,
    onPrimary = Colors.Light.text,
    surface = Colors.Light.surface,
    background = Colors.Light.background
)

@Composable
fun Theme(isDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        content = content,
        colors = if (isDarkTheme) DarkColorScheme else LightColorScheme
    )
}