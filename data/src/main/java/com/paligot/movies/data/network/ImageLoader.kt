package com.paligot.movies.data.network

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.*
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.io.IOException
import javax.imageio.ImageIO
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

object ImageLoader {
  private val httpClient = OkHttpClient()
  private val cache: MutableMap<String, ByteArray?> = mutableMapOf()

  suspend fun load(url: String): ByteArray? {
    if (cache.containsKey(url) && cache[url] != null) return cache[url]
    val image = httpClient.loadImage(url)
    cache[url] = image
    return image
  }
}

suspend fun OkHttpClient.loadImage(url: String): ByteArray? {
  val request = Request.Builder().url(url).build()
  val response = newCall(request).await()
  if (!response.isSuccessful) return null
  val bufferedImage: BufferedImage = ImageIO.read(response.body?.byteStream()) ?: return null
  val stream = ByteArrayOutputStream()
  ImageIO.write(bufferedImage, "png", stream)
  return stream.toByteArray()
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
    } catch (_: Throwable) {
    }
  }
}
