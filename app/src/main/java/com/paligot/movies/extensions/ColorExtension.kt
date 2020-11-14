package com.paligot.movies.extensions

import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.Color

@ColorInt
fun Color.legacy(): Int {
  return -0x1000000 or
      ((red * 255.0f + 0.5f).toInt() shl 16) or
      ((green * 255.0f + 0.5f).toInt() shl 8) or
      (blue * 255.0f + 0.5f).toInt()
}