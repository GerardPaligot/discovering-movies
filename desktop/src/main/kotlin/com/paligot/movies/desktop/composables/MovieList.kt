package com.paligot.movies.desktop.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paligot.movies.components.MovieItem
import com.paligot.movies.data.models.Movie

@Composable
fun MovieList(
  title: String,
  movies: List<Movie>,
  modifier: Modifier = Modifier,
  onClick: (movie: Movie) -> Unit
) {
  Column(modifier = modifier) {
    Text(
      text = title,
      style = MaterialTheme.typography.h6
    )
    LazyColumn(
      modifier = Modifier.padding(end = 8.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
      contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp)
    ) {
      items(movies) { movie ->
        MovieItem(
          title = movie.title,
          pictureUrl = movie.pictureUrl,
          rating = movie.percentage,
          genres = movie.genres,
          releaseDate = movie.releaseDate,
          runtime = movie.runtime,
          onClick = { onClick(movie) }
        )
      }
    }
  }
}
