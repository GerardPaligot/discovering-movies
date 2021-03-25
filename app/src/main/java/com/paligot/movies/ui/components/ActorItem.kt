package com.paligot.movies.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage
import com.paligot.movies.data.joker
import com.paligot.movies.theming.ExploringMoviesTheme
import com.paligot.movies.theming.actorGradient

@Composable
fun ActorItem(
  name: String,
  pictureUrl: String,
  modifier: Modifier = Modifier
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
  ) {
    BoxWithConstraints {
      val boxWidth = with(LocalDensity.current) { constraints.maxWidth.toDp() }
      val boxHeight = with(LocalDensity.current) { constraints.maxHeight.toDp() }
      val largestSize = if (boxWidth.value > boxHeight.value) boxHeight else boxWidth
      Surface(
        modifier = Modifier
          .size(largestSize)
          .border(
            shape = CircleShape,
            border = BorderStroke(
              3.dp,
              brush = Brush.linearGradient(
                actorGradient,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = largestSize.value, y = largestSize.value * 3)
              )
            )
          ),
        shape = CircleShape
      ) {
        CoilImage(
          data = pictureUrl,
          modifier = Modifier.fillMaxSize(),
          contentScale = ContentScale.Crop,
          contentDescription = null
        )
      }
    }
    Text(
      text = name,
      style = MaterialTheme.typography.caption,
      textAlign = TextAlign.Center
    )
  }
}

@Preview
@Composable
fun ActorItemPreview() {
  ExploringMoviesTheme() {
    ActorItem(
      joker.actors[0].name,
      joker.actors[0].profilePath,
      modifier = Modifier
        .padding(5.dp)
        .width(100.dp)
    )
  }
}