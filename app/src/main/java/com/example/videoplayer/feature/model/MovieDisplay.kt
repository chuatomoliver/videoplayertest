package com.example.videoplayer.feature.model

import com.example.videoplayer.core.abstraction.RecyclerViewItem

data class MovieDisplay(
    override val id: Int = 0,
    val uid: String = "",
    val title: String = "",
    val description: String = "",
    val thumbnail: String
) : RecyclerViewItem()
