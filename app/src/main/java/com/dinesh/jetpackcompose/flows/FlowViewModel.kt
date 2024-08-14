package com.dinesh.jetpackcompose.flows

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlowViewModel : ViewModel() {

    fun countDownFlow() : Flow<Int> {
        return flow {
            val startingValue = 10
            var currentValue = startingValue
            emit(startingValue)
            while (currentValue > 0) {
                delay(1000L)
                currentValue--
                emit(currentValue)
            }

        }
    }
}