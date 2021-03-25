package com.paligot.movies.ui.components

import android.content.res.Configuration
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage
import com.paligot.movies.data.joker
import com.paligot.movies.extensions.opposite
import com.paligot.movies.theming.ExploringMoviesTheme
import com.paligot.movies.theming.components.Rating

@Composable
fun Poster(
  width: Dp,
  height: Dp,
  modifier: Modifier = Modifier,
  elevation: Dp = 2.dp,
  content: @Composable () -> Unit
) {
  Surface(
    modifier = modifier
      .width(width = width)
      .height(height = height),
    shape = MaterialTheme.shapes.large,
    elevation = elevation
  ) {
    content()
  }
}


@Composable
fun Poster(
  pictureUrl: String,
  width: Dp,
  height: Dp,
  modifier: Modifier = Modifier,
  elevation: Dp = 2.dp
) {
  Poster(
    width = width,
    height = height,
    modifier = modifier,
    elevation = elevation,
  ) {
    CoilImage(
      data = pictureUrl,
      modifier = Modifier.fillMaxSize(),
      contentScale = ContentScale.FillHeight,
      contentDescription = null
    )
  }
}

@Composable
fun PosterNoted(
  posterUrl: String,
  voteAverage: Int,
  ratingSize: Dp,
  ratingAlignment: Alignment,
  onClick: () -> Unit = {}
) {
  BoxWithConstraints {
    val boxWidth = with(LocalDensity.current) { constraints.maxWidth.toDp() }
    val boxHeight = with(LocalDensity.current) { constraints.maxHeight.toDp() }
    Box(modifier = Modifier.fillMaxSize()) {
      CompositionLocalProvider(LocalIndication provides rememberRipple(color = MaterialTheme.colors.primary)) {
        Poster(
          pictureUrl = posterUrl,
          width = boxWidth.minus(ratingSize.div(2)),
          height = boxHeight.minus(ratingSize.div(2)),
          modifier = Modifier
            .align(alignment = ratingAlignment.opposite())
            .clickable(onClick = onClick),
          elevation = 0.dp
        )
      }
      Box(
        modifier = Modifier
          .align(alignment = ratingAlignment)
          .size(ratingSize)
      ) {
        Rating(percentage = voteAverage)
      }
    }
  }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PosterNotedPreview() {
  ExploringMoviesTheme(isDarkMode = true) {
    Surface(modifier = Modifier.fillMaxSize()) {
      Box(modifier = Modifier.wrapContentSize(Alignment.Center)) {
        Box(
          modifier = Modifier
            .width(200.dp)
            .aspectRatio(0.7f)
        ) {
          PosterNoted(
            posterUrl = joker.poster,
            voteAverage = joker.voteAverage,
            ratingSize = 70.dp,
            ratingAlignment = Alignment.TopEnd
          )
        }
      }
    }
  }
}