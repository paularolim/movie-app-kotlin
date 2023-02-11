package com.paularolim.movieapp.ui.theme

import androidx.compose.ui.graphics.Color

sealed class Colors(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val text: Color,
) {
    object Dark : Colors(
        background = Color(0xFF111111),
        surface = Color(0xFF111111),
        primary = Color(0xFF7A1F1F),
        text = Color(0xFFFFFFFF),
    )

    object Light : Colors(
        background = Color(0xFFFFFFFF),
        surface = Color(0xFFFFFFFF),
        primary = Color(0xFF7A1F1F),
        text = Color(0xFF000000),
    )
}