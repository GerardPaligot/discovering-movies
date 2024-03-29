package com.paligot.movies.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

@Composable
fun RemoteImage(
  url: String,
  contentDescription: String?,
  modifier: Modifier = Modifier,
  contentScale: ContentScale = ContentScale.Fit
) {
  CrossRemoteImage(
    url = url,
    contentDescription = contentDescription,
    modifier = modifier,
    contentScale = contentScale
  )
}
