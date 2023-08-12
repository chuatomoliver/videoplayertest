package com.example.videoplayer.feature.movielist

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.videoplayer.R
import com.example.videoplayer.core.extension.observe
import com.example.videoplayer.core.extension.viewBinding
import com.example.videoplayer.databinding.FragmentMovieListBinding
import com.example.videoplayer.feature.model.MovieDisplay
import com.example.videoplayer.feature.movieplayer.MoviePlayerActivity
import com.example.videoplayer.util.AppConstant
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list),
    MovieListAdapter.OnMovieItemClickListener {

    private val _binding by viewBinding(FragmentMovieListBinding::bind)
    private val _viewModel by viewModels<MovieListViewModel>()

    @Inject
    lateinit var adapter: MovieListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        with(_binding) {
            adapter.onMovieItemClickListener = this@MovieListFragment
            rvMovieList.layoutManager = LinearLayoutManager(requireContext())
            rvMovieList.adapter = adapter
        }
        with(_viewModel) {
            show()
            movies.observe(this@MovieListFragment) {
                adapter.submitList(it)
            }
        }
    }


    override fun onMovieClick(movie: MovieDisplay) {
        val intent =
            Intent(
                context,
                MoviePlayerActivity::class.java
            )
        intent.putExtra(AppConstant.INTENT_URL, AppConstant.BASE_VIDEO_URL + movie.uid)
        startActivity(intent)
    }
}