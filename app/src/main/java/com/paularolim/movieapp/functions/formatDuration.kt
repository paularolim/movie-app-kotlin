package com.paularolim.movieapp.functions

fun formatDuration(duration: String): String {
    if (duration.isBlank() || duration.isEmpty()) {
        return ""
    }
    val inHours = duration.toInt() / 60.0
    return if (inHours < 2) "${duration}min" else "${inHours}hrs"
}