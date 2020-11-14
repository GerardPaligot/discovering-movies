package com.paligot.movies.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.paligot.movies.data.Movie
import com.paligot.movies.data.MovieViewModel
import com.paligot.movies.data.movies
import com.paligot.movies.ui.ExploringMoviesTheme

@Composable
fun MovieListViewModel(
  movieSection: MovieSection,
  isDarkModeActive: Boolean,
  switchDarkMode: () -> Unit = {},
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
    isDarkModeActive = isDarkModeActive,
    switchDarkMode = switchDarkMode,
    onClick = onClick
  )
}

@Composable
fun MovieList(
  title: String,
  movies: List<Movie>,
  isDarkModeActive: Boolean,
  switchDarkMode: () -> Unit = {},
  onClick: (movie: Movie) -> Unit
) {
  MovieScaffold(title = title, isDarkModeActive = isDarkModeActive, switchDarkMode = switchDarkMode) {
    LazyColumnFor(items = movies) {
      MovieItem(
        movie = it,
        modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp),
        onClick = onClick
      )
    }
  }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MovieListDarkPreview() {
  ExploringMoviesTheme(isDarkMode = true) {
    Surface(modifier = Modifier.fillMaxSize()) {
      MovieList(
        title = "Populars",
        movies = movies,
        isDarkModeActive = true,
        switchDarkMode = {}
      ) {}
    }
  }
}

@Preview
@Composable
fun MovieListLightPreview() {
  ExploringMoviesTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      MovieList(
        title = "Populars",
        movies = movies,
        isDarkModeActive = false,
        switchDarkMode = {}
      ) {}
    }
  }
}