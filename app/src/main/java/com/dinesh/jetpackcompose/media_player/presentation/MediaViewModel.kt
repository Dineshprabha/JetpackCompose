package com.dinesh.jetpackcompose.media_player.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinesh.jetpackcompose.media_player.data.model.Msg
import com.dinesh.jetpackcompose.media_player.data.repository.MediaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MediaViewModel @Inject constructor(
    private val mediaRepository: MediaRepository,
) : ViewModel() {

    private val _videos = MutableStateFlow<List<Msg>>(emptyList())
    val videos: StateFlow<List<Msg>> = _videos

    init {
        fetchVideos()
    }

    private fun fetchVideos() {
        viewModelScope.launch {
            try {
                val response = mediaRepository.getAllVideos()
                _videos.value = response.msg
                Log.i("Media: ", response.msg.toString())
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}