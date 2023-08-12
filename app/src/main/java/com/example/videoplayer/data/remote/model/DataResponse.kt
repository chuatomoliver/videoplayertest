package com.example.videoplayer.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataResponse(
    @Json(name = "videos")
    val videos: VideosResponse,
)