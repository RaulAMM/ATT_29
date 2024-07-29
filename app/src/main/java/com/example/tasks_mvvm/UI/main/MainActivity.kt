package com.example.tasks_mvvm.UI.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasks_mvvm.R
import com.example.tasks_mvvm.UI.adapter.TaskAdapter
import com.example.tasks_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = TaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView(){
        binding.recyclerTasks.layoutManager = LinearLayoutManager(this)

        binding.recyclerTasks.adapter = adapter
    }

    private fun setupObservers(){
        viewModel.tasks.observe(this,Observer{
            adapter.submitDataset(it)
            adapter.notifyDataSetChanged()
        })
    }
}