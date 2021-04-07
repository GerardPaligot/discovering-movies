package com.paligot.movies.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.google.accompanist.coil.CoilImage

@Composable
actual fun RemoteImage(
  url: String,
  contentDescription: String?,
  modifier: Modifier,
  contentScale: ContentScale
) {
  CoilImage(
    data = url,
    modifier = modifier,
    contentDescription = contentDescription,
    contentScale = ContentScale.Crop,
  )
}