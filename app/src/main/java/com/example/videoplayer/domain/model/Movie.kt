package com.example.videoplayer.domain.model


data class Movie(
    val id: Int,
    val videoUid: String,
    val videoTitle: String,
    val videoThumbnail: String
)