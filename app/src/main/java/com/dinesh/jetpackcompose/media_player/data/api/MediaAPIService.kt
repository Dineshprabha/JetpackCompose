package com.dinesh.jetpackcompose.media_player.data.api

import com.dinesh.jetpackcompose.media_player.data.model.MediaResponse
import retrofit2.http.GET

interface MediaAPIService {

    @GET("index.php?p=showAllVideos")
    suspend fun getAllVideos(): MediaResponse
}