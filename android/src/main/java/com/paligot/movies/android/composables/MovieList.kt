package com.paligot.movies.android.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paligot.movies.components.MovieItem
import com.paligot.movies.components.MovieScaffold
import com.paligot.movies.data.models.Movie
import com.paligot.movies.data.movies
import com.paligot.movies.theming.ExploringMoviesTheme

@Composable
fun MovieList(
  title: String,
  movies: List<Movie>,
  onClick: (movie: Movie) -> Unit
) {
  MovieScaffold(title = title) {
    LazyColumn(contentPadding = PaddingValues(start = 16.dp, end = 16.dp)) {
      items(movies) {
        MovieItem(
          title = it.title,
          pictureUrl = it.pictureUrl,
          rating = it.percentage,
          genres = it.genres,
          releaseDate = it.releaseDate,
          runtime = it.runtime,
          modifier = Modifier.padding(top = 8.dp),
          onClick = {
            onClick(it)
          }
        )
      }
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
        movies = movies
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
        movies = movies
      ) {}
    }
  }
}
