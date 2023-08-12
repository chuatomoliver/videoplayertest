package com.example.videoplayer.domain.abstraction

import com.example.videoplayer.domain.model.Movie
import kotlinx.coroutines.flow.Flow


/**
 *  Abstraction for Repository, this is the contract that data layer needs to implement
 */
interface Repository {
    fun showMovies(): Flow<List<Movie>>
}