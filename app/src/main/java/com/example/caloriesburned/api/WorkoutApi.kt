package com.example.caloriesburned.api

import com.example.caloriesburned.model.Workout
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WorkoutApi {
    @Headers(
        "X-RapidAPI-Key: e0840a4e14mshde701a6cd6319fdp17255fjsn8da0197305f3",
        "X-RapidAPI-Host: calories-burned-by-api-ninjas.p.rapidapi.com")
    @GET("v1/caloriesburned")
    suspend fun getWorkouts(
        @Query("activity") action: String,
        @Query("weight") bodyWeight: Double?,
        @Query("duration") timeSpent: String?): List<Workout>
}