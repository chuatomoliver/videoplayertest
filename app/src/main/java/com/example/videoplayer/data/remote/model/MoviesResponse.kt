package com.example.videoplayer.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResponse(
    @Json(name = "id")
    val videoId: Int,
    @Json(name = "video_uid")
    val videoUid: String,
    @Json(name = "video_title")
    val videoTitle: String,
    @Json(name = "video_thumbnail")
    val thumbnail: String
)