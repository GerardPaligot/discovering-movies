package com.paligot.movies.desktop.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paligot.movies.components.MovieNotedItem
import com.paligot.movies.data.models.Movie

@Composable
fun MovieNotedList(
  title: String,
  movies: List<Movie>,
  modifier: Modifier = Modifier,
  onClick: (movie: Movie) -> Unit
) {
  Column(modifier = modifier) {
    Text(
      text = title,
      style = MaterialTheme.typography.h6,
      modifier = Modifier.padding(start = 16.dp)
    )
    LazyRow(
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
      contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
      items(movies) { movie ->
        MovieNotedItem(
          title = movie.title,
          pictureUrl = movie.pictureUrl,
          rating = movie.percentage,
          releaseDate = movie.releaseDate,
          runtime = movie.runtime,
          onClick = { onClick(movie) }
        )
      }
    }
  }
}


