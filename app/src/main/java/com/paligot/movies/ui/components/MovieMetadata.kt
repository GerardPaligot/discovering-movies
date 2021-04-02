package com.paligot.movies.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paligot.movies.data.joker
import com.paligot.movies.extensions.formatDate
import com.paligot.movies.theming.ExploringMoviesTheme
import java.util.*

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
      val year = releaseDate.formatDate().get(Calendar.YEAR)
      val time = "${runtime / 60}h ${runtime % 60}min"
      Text(
        text = if (runtime != 0) "$year - $time" else "$year",
        modifier = Modifier.padding(top = 5.dp)
      )
    }
  }
}

@Preview
@Composable
fun MovieMetadataPreview() {
  ExploringMoviesTheme(isDarkMode = true) {
    Surface(modifier = Modifier.fillMaxSize()) {
      MovieMetadata(
        title = joker.title,
        genres = joker.genres,
        releaseDate = joker.releaseDate,
        runtime = joker.runtime,
        modifier = Modifier
          .wrapContentWidth(align = Alignment.CenterHorizontally)
          .wrapContentHeight(align = Alignment.CenterVertically)
      )
    }
  }
}
