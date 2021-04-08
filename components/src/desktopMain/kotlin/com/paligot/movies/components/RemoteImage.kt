package com.paligot.movies.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.*
import org.jetbrains.skija.Image
import java.io.ByteArrayOutputStream
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import javax.imageio.ImageIO

@Composable
actual fun RemoteImage(
  url: String,
  contentDescription: String?,
  modifier: Modifier,
  contentScale: ContentScale
) {
  val httpClient = remember { OkHttpClient() }
  val image = remember(url) { mutableStateOf<ImageBitmap?>(null) }
  LaunchedEffect(url) {
    httpClient.loadImage(url)?.let {
      image.value = it
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

internal suspend fun OkHttpClient.loadImage(url: String): ImageBitmap? {
  val request = Request.Builder().url(url).build()
  val response = newCall(request).await()
  if (!response.isSuccessful) return null
  val bufferedImage = ImageIO.read(response.body?.byteStream())
  if (bufferedImage == null) return null
  val stream = ByteArrayOutputStream()
  ImageIO.write(bufferedImage, "png", stream)
  val byteArray = stream.toByteArray()
  return Image.makeFromEncoded(byteArray).asImageBitmap()
}

internal suspend inline fun Call.await(): Response {
  return suspendCancellableCoroutine { continuation ->
    val callback = ContinuationCallback(this, continuation)
    enqueue(callback)
    continuation.invokeOnCancellation(callback)
  }
}

internal class ContinuationCallback(
  private val call: Call,
  private val continuation: CancellableContinuation<Response>
) : Callback, CompletionHandler {

  override fun onResponse(call: Call, response: Response) {
    continuation.resume(response)
  }

  override fun onFailure(call: Call, e: IOException) {
    if (!call.isCanceled()) {
      continuation.resumeWithException(e)
    }
  }

  override fun invoke(cause: Throwable?) {
    try {
      call.cancel()
    } catch (_: Throwable) {}
  }
}
