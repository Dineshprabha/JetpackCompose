package com.dinesh.jetpackcompose.todo.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

data class ToDo(
    val id: Int,
    val title: String,
    val createdAt: Date,
)


@RequiresApi(Build.VERSION_CODES.O)
fun getFakeTodo(): List<ToDo> {
    return listOf(
        ToDo(1, "First", Date.from(Instant.now())),
        ToDo(1, "Second", Date.from(Instant.now())),
        ToDo(1, "Third", Date.from(Instant.now())),
        ToDo(1, "Fourth", Date.from(Instant.now())),
    )
}