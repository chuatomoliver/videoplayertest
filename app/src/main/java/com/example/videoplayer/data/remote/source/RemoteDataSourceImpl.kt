package com.example.videoplayer.data.remote.source


import com.example.videoplayer.data.RemoteDataSource
import com.example.videoplayer.data.remote.VideoPlayerService
import com.example.videoplayer.data.remote.model.MoviesResponse
import javax.inject.Inject


/**
 *  Implementation of remote data source
 */
class RemoteDataSourceImpl @Inject constructor(
    private val service: VideoPlayerService
) : RemoteDataSource {


    override suspend fun showMovies(): List<MoviesResponse> {
        return service.showMovie().data.videos.videosData
    }


}