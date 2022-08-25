package com.example.caloriesburned.model

data class Workout (
    val activity: String,
    val caloriesPerHour: Double,
    val activityDurationInMinutes: Int,
    val totalCalories: Double
)
