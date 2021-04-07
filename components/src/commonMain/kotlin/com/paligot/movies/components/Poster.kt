package com.paligot.movies.components

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.paligot.movies.extensions.opposite
import com.paligot.movies.extensions.paddingValues

@Composable
fun Poster(
  pictureUrl: String,
  modifier: Modifier = Modifier,
  elevation: Dp = 2.dp
) {
  CompositionLocalProvider(
    LocalIndication provides rememberRipple(color = MaterialTheme.colors.primary)
  ) {
    Surface(
      modifier = modifier
        .fillMaxWidth()
        .aspectRatio(.6f),
      shape = MaterialTheme.shapes.large,
      color = MaterialTheme.colors.surface,
      elevation = elevation
    ) {
      RemoteImage(
        url = pictureUrl,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillHeight,
        contentDescription = null
      )
    }
  }
}

@Composable
fun PosterNoted(
  posterUrl: String,
  voteAverage: Int,
  modifier: Modifier = Modifier,
  ratingAlignment: Alignment = Alignment.TopEnd,
  onClick: () -> Unit = {}
) {
  BoxWithConstraints(modifier = modifier) {
    val ratingSize = maxWidth / 3
    Poster(
      pictureUrl = posterUrl,
      modifier = Modifier
        .padding(ratingAlignment.paddingValues(ratingSize.div(2)))
        .align(alignment = ratingAlignment.opposite())
        .clickable(onClick = onClick),
      elevation = 1.dp
    )
    Rating(
      percentage = voteAverage,
      modifier = Modifier
        .align(alignment = ratingAlignment)
        .size(ratingSize)
    )
  }
}
