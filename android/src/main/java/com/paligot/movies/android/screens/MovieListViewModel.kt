package com.paligot.movies.android.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.paligot.movies.android.MovieViewModel
import com.paligot.movies.android.composables.MovieList
import com.paligot.movies.data.Movie
import com.paligot.movies.data.MovieSection

@Composable
fun MovieListViewModel(
  movieSection: MovieSection,
  onClick: (movie: Movie) -> Unit
) {
  val viewModel: MovieViewModel = viewModel()
  val movies = when (movieSection) {
    MovieSection.UPCOMING -> viewModel.getUpComing().collectAsState(initial = emptyList())
    MovieSection.POPULAR -> viewModel.getPopulars().collectAsState(initial = emptyList())
    MovieSection.TRENDING -> viewModel.getDailyTrending().collectAsState(initial = emptyList())
  }
  val title = when (movieSection) {
    MovieSection.UPCOMING -> "Upcoming"
    MovieSection.POPULAR -> "Populars"
    MovieSection.TRENDING -> "Trending"
  }
  MovieList(
    title = title,
    movies = movies.value,
    onClick = onClick
  )
}
