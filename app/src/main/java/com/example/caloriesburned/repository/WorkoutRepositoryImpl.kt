package com.example.caloriesburned.repository

import androidx.lifecycle.MutableLiveData
import com.example.caloriesburned.api.NetworkResult
import com.example.caloriesburned.api.RetrofitBuilder
import com.example.caloriesburned.api.WorkoutApi
import com.example.caloriesburned.model.Workout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkoutRepositoryImpl(): WorkoutRepository {
    override suspend fun getWorkouts(
        action: String,
        weight: Double?,
        duration: String?
    ) : NetworkResult<List<Workout>?> {
        withContext(Dispatchers.IO) {
            try {
                val response = RetrofitBuilder.api.getWorkouts(action, weight, duration)
               // if (response.isS)
            } catch (e: Exception) {
                NetworkResult.Error(e.message.toString(), null)
            }
        }
    }
}