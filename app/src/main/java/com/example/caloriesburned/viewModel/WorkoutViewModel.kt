package com.example.caloriesburned.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caloriesburned.model.Workout
import com.example.caloriesburned.repository.WorkoutRepository
import com.example.caloriesburned.usecase.WorkoutUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.LinkedList

class WorkoutViewModel(private val workoutRepo: WorkoutRepository): ViewModel() {
    val workoutsLiveData : LiveData<List<Workout>>
       get() = workoutsData
    private var workoutsData = MutableLiveData<List<Workout>>()


     fun getWorkouts(activity: String){
         viewModelScope.launch(Dispatchers.Main) {
             val response = WorkoutUseCase(workoutRepo).getWorkouts(activity);
             workoutsData.value = workoutRepo.getWorkouts(activity)
         }
        // todo add repository call here
       // workoutsData.value = contentProvider()
    }

    private fun contentProvider():LinkedList<Workout> {
        val list = LinkedList<Workout>()
        val w1 = Workout(activity="Walk/run, playing with children, moderate",
            caloriesPerHour = 217.0,
            activityDurationInMinutes = 60,
            totalCalories = 217.0)
        val w2 = Workout(activity="Walk/run, playing with children, vigorous",
            caloriesPerHour = 272.0,
            activityDurationInMinutes = 60,
            totalCalories = 272.0)
        val w3 = Workout(activity="Walk / run, playing with animals",
            caloriesPerHour = 220.0,
            activityDurationInMinutes = 60,
            totalCalories = 220.0)
        list.add(w1)
        list.add(w2)
        list.add(w3)
        return list
    }
}