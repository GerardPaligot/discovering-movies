package com.paligot.movies.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.viewModel
import com.paligot.movies.data.Movie
import com.paligot.movies.data.MovieViewModel
import com.paligot.movies.data.movies
import com.paligot.movies.ui.ExploringMoviesTheme

@Composable
fun MovieHomeViewModel(
  isDarkModeActive: Boolean,
  onViewAllClick: (movieSection: MovieSection) -> Unit = {},
  switchDarkMode: () -> Unit = {},
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
    isDarkModeActive = isDarkModeActive,
    onViewAllClick = onViewAllClick,
    switchDarkMode = switchDarkMode,
    onClick = onClick
  )
}

@Composable
fun MovieHome(
  upComing: List<Movie>,
  populars: List<Movie>,
  trending: List<Movie>,
  isDarkModeActive: Boolean,
  onViewAllClick: (movieSection: MovieSection) -> Unit = {},
  switchDarkMode: () -> Unit = {},
  onClick: (movie: Movie) -> Unit
) {
  MovieScaffold(isDarkModeActive = isDarkModeActive, switchDarkMode = switchDarkMode) {
    ScrollableColumn {
      HomeSection(
        movieSection = MovieSection.UPCOMING,
        title = "Upcoming",
        movies = upComing,
        modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp),
        onClick = onClick,
        onViewAllClick = onViewAllClick
      )
      HomeSection(
        movieSection = MovieSection.POPULAR,
        title = "Popular",
        movies = populars,
        modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp),
        onClick = onClick,
        onViewAllClick = onViewAllClick
      )
      HomeSection(
        movieSection = MovieSection.TRENDING,
        title = "Trending",
        movies = trending,
        modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp),
        onClick = onClick,
        onViewAllClick = onViewAllClick
      )
    }
  }
}

@Composable
fun HomeSection(
  movieSection: MovieSection,
  title: String,
  movies: List<Movie>,
  modifier: Modifier = Modifier,
  onViewAllClick: (movieSection: MovieSection) -> Unit,
  onClick: (movie: Movie) -> Unit
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .wrapContentHeight(align = Alignment.CenterVertically)
  ) {
    Text(
      text = title,
      style = MaterialTheme.typography.subtitle1.copy(fontSize = 20.sp)
    )
    Text(
      text = "View all",
      style = MaterialTheme.typography.overline,
      modifier = Modifier
        .align(alignment = Alignment.CenterEnd)
        .fillMaxHeight()
        .clickable(
          onClick = { onViewAllClick(movieSection) },
          indication = rememberRipple(bounded = false)
        )
    )
  }
  LazyRow {
    itemsIndexed(movies) { index, it ->
      Box(
        modifier = Modifier.padding(
          start = if (index == 0) 10.dp else 0.dp,
          end = 5.dp, top = 5.dp, bottom = 5.dp
        )
      ) {
        Poster(pictureUrl = it.pictureUrl, width = 120.dp, height = 180.dp) { onClick(it) }
      }
    }
  }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MovieHomePreview() {
  ExploringMoviesTheme(isDarkMode = true) {
    MovieHome(movies, movies, movies, isDarkModeActive = true) {}
  }
}