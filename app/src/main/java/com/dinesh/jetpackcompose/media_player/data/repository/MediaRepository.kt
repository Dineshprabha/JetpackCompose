package com.dinesh.jetpackcompose.media_player.data.repository

import com.dinesh.jetpackcompose.media_player.data.api.MediaAPIService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediaRepository @Inject constructor(
    private val mediaAPIService: MediaAPIService
) {

    suspend fun getAllVideos() = mediaAPIService.getAllVideos()
}