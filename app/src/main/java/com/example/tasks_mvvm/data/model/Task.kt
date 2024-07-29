package com.example.tasks_mvvm.data.model

class Task (var description: String, var isCompleted: Boolean){
    private companion object{
        var lasId: Long = 1L
    }

    var id: Long = 0L

    init {
        lasId += 1
        id = lasId
    }
}