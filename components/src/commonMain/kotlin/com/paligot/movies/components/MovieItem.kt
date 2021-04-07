package com.paligot.movies.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun MovieItem(
  title: String,
  pictureUrl: String,
  rating: Int,
  genres: List<String>,
  releaseDate: String,
  runtime: Int,
  modifier: Modifier = Modifier,
  onClick: () -> Unit
) {
  val posterWidth = 130
  val height = (posterWidth / 0.65f).roundToInt()
  Box(modifier = modifier) {
    Surface(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 60.dp)
        .height((height - 60).dp)
        .clickable(onClick = onClick),
      shape = MaterialTheme.shapes.large,
      elevation = 5.dp
    ) {
      MovieMetadata(
        title = title,
        genres = genres,
        releaseDate = releaseDate,
        runtime = runtime,
        modifier = Modifier
          .padding(start = posterWidth.dp)
          .wrapContentHeight(align = Alignment.CenterVertically)
      )
    }
    PosterNoted(
      posterUrl = pictureUrl,
      voteAverage = rating,
      modifier = Modifier
        .width(posterWidth.dp)
        .padding(start = 16.dp)
    )
  }
}
