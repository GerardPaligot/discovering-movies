package com.paligot.movies.desktop

import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paligot.movies.components.Poster
import com.paligot.movies.theming.ExploringMoviesTheme

fun main() = Window {
  ExploringMoviesTheme {
    Box(
      modifier = Modifier.fillMaxSize()
        .wrapContentSize(align = Alignment.Center)
    ) {
      Poster(
        pictureUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg",
        modifier = Modifier.width(250.dp).aspectRatio(1f)
      )
    }
  }
}
