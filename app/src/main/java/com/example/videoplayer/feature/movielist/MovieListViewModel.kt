package com.example.videoplayer.feature.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.videoplayer.domain.abstraction.PostExecutionThread
import com.example.videoplayer.domain.useCase.ShowMovies
import com.example.videoplayer.feature.model.MovieDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val postExecutionThread: PostExecutionThread,
    private val showMovie: ShowMovies
) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, _ -> }
    private val _pagingDataList = MutableStateFlow(arrayListOf<MovieDisplay>())
    val movies: StateFlow<List<MovieDisplay>> get() = _pagingDataList


    fun show() {
        viewModelScope.launch(postExecutionThread.io + exceptionHandler) {
            showMovie("").collect {
                val movies = arrayListOf<MovieDisplay>()
                it.forEachIndexed { index, movie ->
                    with(movie) {
                        with(movie) {
                            movies.add(
                                MovieDisplay(
                                    id = index,
                                    uid = videoUid,
                                    title = videoTitle,
                                    thumbnail = videoThumbnail,

                                    )
                            )
                        }
                    }
                }
                _pagingDataList.value = movies
            }
        }
    }
}
