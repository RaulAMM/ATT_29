package com.example.tasks_mvvm.UI.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tasks_mvvm.data.model.Task
import com.example.tasks_mvvm.data.repository.TasksRepository
import com.example.tasks_mvvm.dto.TaskDto

class MainViewModel: ViewModel() {

    private val repository = TasksRepository()

    private val _tasks = MutableLiveData<List<TaskDto>>()
    val tasks: LiveData<List<TaskDto>> = _tasks

    init {
        loadData()
    }

    private fun loadData(){
        val taskList = repository.findAll()
        val taskDtoList = taskList.map { task: Task -> TaskDto(task.id, task.description, task.isCompleted) }
    }

}