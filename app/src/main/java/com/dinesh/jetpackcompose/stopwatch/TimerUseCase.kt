package com.dinesh.jetpackcompose.stopwatch

import android.os.SystemClock
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable.isActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TimerUseCase(
    private val coroutineScope: CoroutineScope,
) {

    private val _timerState = MutableStateFlow<TimerState>(TimerState.Paused)
    val timerState: StateFlow<TimerState> = _timerState.asStateFlow()

    private var timerJob: Job? = null
    private var timeLeftOnPause: Long = 0L

    fun startTimer(totalMillis: Long, intervalMillis: Long) {
        timerJob?.cancel()
        timerJob = coroutineScope.launch(Dispatchers.Default) {
            val endTime = SystemClock.elapsedRealtime() + totalMillis
            runTimer(endTime, intervalMillis)
        }
    }

    fun pauseTimer() {
        timerJob?.cancel()
        if (_timerState.value is TimerState.Running) {
            timeLeftOnPause = (_timerState.value as TimerState.Running).millisLeft
        }
        _timerState.value = TimerState.Paused
    }

    fun resumeTimer(intervalMillis: Long) {
        if (timeLeftOnPause > 0) {
            timerJob?.cancel()
            timerJob = coroutineScope.launch(Dispatchers.Default) {
                val endTime = SystemClock.elapsedRealtime() + timeLeftOnPause
                runTimer(endTime, intervalMillis)
            }
        }
    }

    fun resetTimer() {
        timerJob?.cancel()
        timeLeftOnPause = 0L
        _timerState.value = TimerState.Finished
    }

    private suspend fun runTimer(endTime: Long, intervalMillis: Long) {
//        while (isActive) {
//            val millisLeft = endTime - SystemClock.elapsedRealtime()
//            if (millisLeft <= 0) {
//                _timerState.value = TimerState.Finished
//                timeLeftOnPause = 0L
//                break
//            } else {
//                val tickStart = SystemClock.elapsedRealtime()
//                _timerState.value = TimerState.Running(millisLeft)
//                val tickDuration = SystemClock.elapsedRealtime() - tickStart
//                val adjustedTickDuration = if (tickDuration < 0) 0 else tickDuration
//                if (millisLeft < mCountdownInterval) {
//                    delay = millisLeft - adjustedTickDuration;
//                    if (delay < 0) delay = 0;
//                } else {
//                    delay = mCountdownInterval - adjustedTickDuration;
//                    while (delay < 0) delay += mCountdownInterval;
//                }
//
//                delay(delayTime)
//            }
//        }
    }
}