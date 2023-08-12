package com.example.videoplayer.data.remote

import com.example.videoplayer.data.remote.model.MovieResponse
import retrofit2.http.*


/**
 *  Service used for API call
 */
interface VideoPlayerService {

    @GET("api")
    suspend fun showMovie(
    ): MovieResponse

}