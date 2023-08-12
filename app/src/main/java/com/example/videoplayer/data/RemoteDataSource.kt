package com.example.videoplayer.data

import com.example.videoplayer.data.remote.model.MoviesResponse

/**
 *  Abstraction for Remote Data Source, this is the contract that remote data layer needs to implement
 */
interface RemoteDataSource {
    suspend fun showMovies(): List<MoviesResponse>
}