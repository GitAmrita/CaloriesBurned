package com.example.caloriesburned.repository

import com.example.caloriesburned.api.NetworkResult
import com.example.caloriesburned.model.Workout

interface WorkoutRepository {
    suspend fun getWorkouts (
        action: String, weight: Double? = null, duration : String? = null): NetworkResult<List<Workout>?>
}