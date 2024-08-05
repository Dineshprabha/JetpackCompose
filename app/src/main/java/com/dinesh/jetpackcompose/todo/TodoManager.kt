package com.dinesh.jetpackcompose.todo

import android.os.Build
import androidx.annotation.RequiresApi
import com.dinesh.jetpackcompose.todo.model.ToDo
import java.time.Instant
import java.util.Date

object TodoManager {
    private val todoList = mutableListOf<ToDo>()

    fun getAllTodo() : List<ToDo>{
        return todoList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title : String){
        todoList.add(ToDo(System.currentTimeMillis().toInt(), title, Date.from(Instant.now())))
    }

    fun deleteTodo(id: Int){
        todoList.removeIf {
            it.id == id
        }
    }
}