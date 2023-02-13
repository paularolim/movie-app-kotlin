package com.paularolim.movieapp.functions

import kotlin.math.floor
import kotlin.math.roundToInt

fun formatDuration(duration: String): String {
    if (duration.isEmpty() || duration.isBlank()) return ""

    val hours = floor(duration.toDouble() / 60.0)
    val minutes = duration.toDouble() % 60

    val hoursSuffix = if (hours == 1.0) "hr" else "hrs"

    return "${hours.roundToInt()}${hoursSuffix} ${minutes.roundToInt()}min"
}