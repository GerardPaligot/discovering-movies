package com.paligot.movies.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.paligot.movies.data.network.ImageLoader

@Composable
actual fun CrossRemoteImage(
  url: String,
  contentDescription: String?,
  modifier: Modifier,
  contentScale: ContentScale
) {
  val image = remember(url) { mutableStateOf<ImageBitmap?>(null) }
  LaunchedEffect(url) {
    ImageLoader.load(url)?.let {
      image.value = org.jetbrains.skia.Image.makeFromEncoded(it).toComposeImageBitmap()
    }
  }
  if (image.value != null) {
    Image(
      bitmap = image.value!!,
      contentDescription = contentDescription,
      modifier = modifier,
      contentScale = contentScale
    )
  }
}
