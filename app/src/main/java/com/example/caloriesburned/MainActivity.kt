package com.example.caloriesburned

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caloriesburned.databinding.ActivityMainBinding
import com.example.caloriesburned.viewModel.WorkoutViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: WorkoutViewModel by lazy {
        ViewModelProvider(this)[WorkoutViewModel::class.java]
    }
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val getBtn: Button by lazy { binding.getBtn }
    private val activityInput: TextView by lazy { binding.activityTxt }
    private val recyclerView: RecyclerView by lazy { binding.workoutRecycler }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initializeRecyclerView()
        observeGetWorkouts()
        setOnClickListener()

    }
    private fun initializeRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeGetWorkouts() {
        viewModel.workoutsLiveData.observe(this, Observer {
            recyclerView.adapter = WorkoutAdapter(it)
            recyclerView.adapter?.notifyDataSetChanged()
        })
    }

    private fun setOnClickListener() {
        val activityInput = activityInput.text.toString()
        getBtn.setOnClickListener{
            viewModel.getWorkouts(activityInput)
        }
    }
}