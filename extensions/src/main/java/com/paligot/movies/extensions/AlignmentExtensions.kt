package com.paligot.movies.extensions

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp

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

fun Alignment.paddingValues(padding: Dp): PaddingValues {
  return when (this) {
    Alignment.TopStart -> PaddingValues(top = padding, start = padding)
    Alignment.TopCenter -> PaddingValues(top = padding)
    Alignment.TopEnd -> PaddingValues(top = padding, end = padding)
    Alignment.BottomEnd -> PaddingValues(bottom = padding, end = padding)
    Alignment.BottomCenter -> PaddingValues(bottom = padding)
    Alignment.BottomStart -> PaddingValues(bottom = padding, start = padding)
    else -> TODO()
  }
}