package com.example.caloriesburned

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.caloriesburned.databinding.CalorieItemBinding
import com.example.caloriesburned.model.Workout

class WorkoutAdapter(private val activities: List<Workout>) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WorkoutAdapter.WorkoutViewHolder {
        val binding = CalorieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkoutAdapter.WorkoutViewHolder, position: Int) {
        holder.bind(activities[position])
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    inner class WorkoutViewHolder(private val binding: CalorieItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(workout: Workout){
            binding.calorieBurntValue.text = workout.caloriesPerHour.toString()
            binding.activityValue.text = workout.activity
            binding.calorieCardItem.setOnClickListener {
                Toast.makeText(binding.calorieCardItem.context, "Coming soon", Toast.LENGTH_SHORT).show()
            }
        }
    }
}