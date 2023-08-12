package com.example.videoplayer.data

import com.example.videoplayer.domain.abstraction.Repository
import com.example.videoplayer.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 *  Implementation of repository bridges all the data sources
 */
class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override fun showMovies(): Flow<List<Movie>> = flow {
        val movieList = arrayListOf<Movie>()
        for (item in remoteDataSource.showMovies()) {
            with(item) {
                movieList.add(
                    Movie(
                        id = videoId,
                        videoUid = videoUid,
                        videoTitle = videoTitle,
                        videoThumbnail = thumbnail
                    )
                )
            }
        }

        emit(movieList)
    }
}