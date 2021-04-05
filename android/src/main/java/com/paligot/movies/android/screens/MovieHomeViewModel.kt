package com.paligot.movies.android.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.paligot.movies.android.MovieViewModel
import com.paligot.movies.android.composables.MovieHome
import com.paligot.movies.data.Movie
import com.paligot.movies.data.MovieSection

@Composable
fun MovieHomeViewModel(
  onViewAllClick: (movieSection: MovieSection) -> Unit = {},
  onClick: (movie: Movie) -> Unit
) {
  val viewModel: MovieViewModel = viewModel()
  val upComing = viewModel.getUpComing().collectAsState(initial = emptyList())
  val populars = viewModel.getPopulars().collectAsState(initial = emptyList())
  val trending = viewModel.getDailyTrending().collectAsState(initial = emptyList())
  MovieHome(
    upComing = upComing.value,
    populars = populars.value,
    trending = trending.value,
    onViewAllClick = onViewAllClick,
    onClick = onClick
  )
}
