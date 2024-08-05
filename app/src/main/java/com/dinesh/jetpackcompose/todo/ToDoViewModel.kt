package com.dinesh.jetpackcompose.todo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dinesh.jetpackcompose.todo.model.ToDo

class ToDoViewModel :ViewModel() {
    private var _todoList = MutableLiveData<List<ToDo>>()
    val todoList : LiveData<List<ToDo>> = _todoList


    fun getAllTodo(){
        _todoList.value = TodoManager.getAllTodo()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title : String){
        TodoManager.addTodo(title)
        getAllTodo()
    }

    fun deleteTodo(id : Int){
        TodoManager.deleteTodo(id)
        getAllTodo()
    }

}