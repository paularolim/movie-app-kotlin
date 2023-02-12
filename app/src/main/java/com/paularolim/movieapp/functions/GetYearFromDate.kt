package com.paularolim.movieapp.functions

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun getYearFromDate(date: String): String {
    if (date.isNotBlank() && date.isNotEmpty()) {
        return try {
            LocalDate.parse(date).year.toString()
        } catch (exception: Exception) {
            Log.e("getYearFromDate", exception.message.toString())
            ""
        }
    }
    return ""
}