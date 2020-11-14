package com.paligot.movies.extensions

import androidx.compose.ui.Alignment

fun Alignment.opposite(): Alignment {
  return when (this) {
    Alignment.TopStart -> Alignment.BottomEnd
    Alignment.TopCenter -> Alignment.BottomCenter
    Alignment.TopEnd -> Alignment.BottomStart
    Alignment.BottomEnd -> Alignment.TopStart
    Alignment.BottomCenter -> Alignment.TopCenter
    Alignment.BottomStart -> Alignment.TopEnd
    else -> TODO()
  }
}