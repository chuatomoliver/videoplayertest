package com.example.videoplayer.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideosResponse(
    @Json(name = "current_page")
    val currentPage: Int,
    @Json(name = "data")
    val videosData: List<MoviesResponse>,
)