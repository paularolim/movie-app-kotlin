package com.paularolim.movieapp.functions

fun formatDuration(duration: String): String {
    if (duration.isBlank() || duration.isEmpty()) {
        return ""
    }
    val inHours = duration.toInt() / 60.0
    if (inHours < 2) return "${duration}min"

    val hoursSpited = inHours.toString().split(".")
    return "${hoursSpited[0]}hrs e ${hoursSpited[1]}min"
}