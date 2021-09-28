package com.paligot.movies.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.google.accompanist.coil.rememberCoilPainter

@Composable
actual fun CrossRemoteImage(
  url: String,
  contentDescription: String?,
  modifier: Modifier,
  contentScale: ContentScale
) {
  Image(
    painter = rememberCoilPainter(request = url),
    modifier = modifier,
    contentDescription = contentDescription,
    contentScale = ContentScale.Crop,
  )
}