package com.paligot.movies.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.paligot.movies.extensions.getYear

@Composable
fun MovieMetadata(
  title: String,
  genres: List<String>,
  releaseDate: String,
  runtime: Int,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier) {
    Text(
      text = title,
      style = MaterialTheme.typography.h6,
      maxLines = 2,
      overflow = TextOverflow.Ellipsis
    )
    Row(modifier = Modifier.padding(top = 5.dp)) {
      genres.take(3).forEach {
        Tag(text = it)
      }
    }
    CompositionLocalProvider(
      LocalContentAlpha provides ContentAlpha.medium
    ) {
      val year = releaseDate.getYear()
      val time = "${runtime / 60}h ${runtime % 60}min"
      Text(
        text = if (runtime != 0) "$year - $time" else "$year",
        modifier = Modifier.padding(top = 5.dp)
      )
    }
  }
}
