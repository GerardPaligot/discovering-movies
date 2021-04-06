package com.paligot.movies.android.composables

import android.content.res.Configuration
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paligot.movies.components.MovieScaffold
import com.paligot.movies.components.Poster
import com.paligot.movies.data.models.Movie
import com.paligot.movies.data.models.MovieSection
import com.paligot.movies.data.movies
import com.paligot.movies.theming.ExploringMoviesTheme


@Composable
fun MovieHome(
  upComing: List<Movie>,
  populars: List<Movie>,
  trending: List<Movie>,
  onViewAllClick: (movieSection: MovieSection) -> Unit = {},
  onClick: (movie: Movie) -> Unit
) {
  MovieScaffold {
    LazyColumn {
      item {
        HomeSection(
          title = "Upcoming",
          movies = upComing,
          onClick = onClick,
          onViewAllClick = { onViewAllClick(MovieSection.UPCOMING) }
        )
      }
      item {
        HomeSection(
          title = "Popular",
          movies = populars,
          onClick = onClick,
          onViewAllClick = { onViewAllClick(MovieSection.POPULAR) }
        )
      }
      item {
        HomeSection(
          title = "Trending",
          movies = trending,
          onClick = onClick,
          onViewAllClick = { onViewAllClick(MovieSection.TRENDING) }
        )
      }
    }
  }
}

@Composable
fun HomeSection(
  title: String,
  movies: List<Movie>,
  modifier: Modifier = Modifier,
  onViewAllClick: () -> Unit,
  onClick: (movie: Movie) -> Unit
) {
  Column(modifier = modifier) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(align = Alignment.CenterVertically)
        .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
      Text(
        text = title,
        style = MaterialTheme.typography.subtitle1
      )
      CompositionLocalProvider(LocalIndication provides rememberRipple(bounded = false)) {
        Text(
          text = "View all",
          style = MaterialTheme.typography.overline,
          modifier = Modifier
            .align(alignment = Alignment.CenterEnd)
            .fillMaxHeight()
            .clickable(onClick = { onViewAllClick() })
        )
      }
    }
    LazyRow(
      contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      items(movies) {
        Poster(
          pictureUrl = it.pictureUrl,
          modifier = Modifier
            .width(120.dp)
            .clickable(onClick = { onClick(it) })
        )
      }
    }
  }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MovieHomePreview() {
  ExploringMoviesTheme(isDarkMode = true) {
    MovieHome(movies, movies, movies) {}
  }
}
