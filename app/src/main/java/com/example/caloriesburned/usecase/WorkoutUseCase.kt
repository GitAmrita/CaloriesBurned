package com.example.caloriesburned.usecase

import com.example.caloriesburned.api.NetworkResult
import com.example.caloriesburned.model.Workout
import com.example.caloriesburned.repository.WorkoutRepository

class WorkoutUseCase(private val workoutRepo: WorkoutRepository) {
    suspend fun getWorkouts(activity: String): NetworkResult<List<Workout>> {
        return workoutRepo.getWorkouts(activity);
    }
}