package com.paligot.movies.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.DensityAmbient
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.paligot.movies.data.joker
import com.paligot.movies.ui.ExploringMoviesTheme
import com.paligot.movies.ui.actorGradient
import dev.chrisbanes.accompanist.coil.CoilImage

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
    WithConstraints {
      val boxWidth = with(DensityAmbient.current) { constraints.maxWidth.toDp() }
      val boxHeight = with(DensityAmbient.current) { constraints.maxHeight.toDp() }
      val largestSize = if (boxWidth.value > boxHeight.value) boxHeight else boxWidth
      Surface(
        modifier = Modifier
          .preferredSize(largestSize)
          .border(
            shape = CircleShape,
            border = BorderStroke(
              3.dp,
              brush = LinearGradient(
                actorGradient,
                startX = 0f,
                endX = largestSize.value,
                startY = 0f,
                endY = largestSize.value * 3
              )
            )
          ),
        shape = CircleShape
      ) {
        CoilImage(
          data = pictureUrl,
          modifier = Modifier.fillMaxSize(),
          contentScale = ContentScale.Crop
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
      modifier = Modifier.padding(5.dp).preferredWidth(100.dp)
    )
  }
}