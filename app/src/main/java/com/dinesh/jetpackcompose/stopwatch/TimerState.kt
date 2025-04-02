package com.dinesh.jetpackcompose.stopwatch

sealed class TimerState {
    data class Running(val millisLeft: Long) : TimerState()
    object Finished : TimerState()
    object Paused : TimerState()
    data class Error(val exception: Throwable) : TimerState()
}