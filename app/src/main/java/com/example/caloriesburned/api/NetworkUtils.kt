package com.example.caloriesburned.api

fun errorCodesHandler(errorCode: Int): String {
    return when(errorCode) {
        in 400..499 -> "Client error. Bad request"
        in 300..399 -> "Cannot handle request at this time"
        in 500..599 -> "Server error"
        else -> "generic error"
    }
}