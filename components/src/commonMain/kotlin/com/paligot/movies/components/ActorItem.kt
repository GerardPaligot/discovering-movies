package com.paligot.movies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.paligot.movies.theming.actorGradient

@Composable
fun ActorItem(
  name: String,
  pictureUrl: String,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier.semantics(mergeDescendants = true) {
      contentDescription = name
    },
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1f)
        .padding(bottom = 8.dp)
        .clip(CircleShape)
        .border(width = 3.dp, brush = Brush.linearGradient(actorGradient), shape = CircleShape)
        .background(color = MaterialTheme.colors.surface, shape = CircleShape)
    ) {
      RemoteImage(
        url = pictureUrl,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        contentDescription = null
      )
    }
    Text(
      text = name,
      style = MaterialTheme.typography.caption,
      textAlign = TextAlign.Center,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis
    )
  }
}
