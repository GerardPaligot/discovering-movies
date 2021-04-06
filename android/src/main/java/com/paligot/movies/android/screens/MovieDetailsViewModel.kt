package com.paligot.movies.android.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.paligot.movies.android.MovieViewModel
import com.paligot.movies.android.composables.MovieDetails
import com.paligot.movies.data.models.Movie

@Composable
fun MovieDetailsViewModel(
  movieId: Int,
  onClick: (movie: Movie) -> Unit
) {
  val viewModel: MovieViewModel = viewModel()
  val movie = viewModel.getMovieDetail(movieId).collectAsState(initial = null)
  movie.value?.let {
    MovieDetails(movie = it, onClick = onClick)
  }
}
