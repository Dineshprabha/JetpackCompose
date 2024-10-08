package com.dinesh.jetpackcompose.media_player.data.model

data class Sound(
    val _id: String,
    val audio_path: AudioPath,
    val created: String,
    val description: String,
    val id: Int,
    val section: String,
    val sound_name: String,
    val thum: String
)