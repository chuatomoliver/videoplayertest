package com.example.videoplayer.domain.useCase


import com.example.videoplayer.domain.BaseUseCase
import com.example.videoplayer.domain.abstraction.PostExecutionThread
import com.example.videoplayer.domain.abstraction.Repository
import com.example.videoplayer.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShowMovies @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val repository: Repository
) : BaseUseCase<String, List<Movie>>(postExecutionThread.io) {

    override fun execute(param: String?): Flow<List<Movie>> {
        return repository.showMovies()
    }

}