package com.paligot.movies.desktop

import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.paligot.movies.desktop.composables.MovieList
import com.paligot.movies.desktop.composables.MovieNotedList
import com.paligot.movies.theming.ExploringMoviesTheme

fun main(args: Array<String>) = Window(title = "Discovering Movies", size = IntSize(900, 1000), resizable = false) {
  val viewModel = remember { MovieViewModel(args[0]) }
  val trending by viewModel.getDailyTrending().collectAsState(emptyList())
  val populars by viewModel.getPopulars().collectAsState(emptyList())
  val upcoming by viewModel.getUpComing().collectAsState(emptyList())
  ExploringMoviesTheme(isDarkMode = true) {
    Scaffold(
      modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.background)
    ) {
      Column {
        MovieNotedList(
          title = "Trending",
          movies = trending,
          modifier = Modifier.padding(top = 16.dp).height(350.dp),
          onClick = {}
        )
        Row(modifier = Modifier.padding(top = 16.dp)) {
          MovieList(
            title = "Popular",
            movies = populars,
            modifier = Modifier.padding(start = 16.dp).weight(weight = 1f, fill = true),
            onClick = {}
          )
          MovieList(
            title = "Upcoming",
            movies = upcoming,
            modifier = Modifier.padding(start = 16.dp).weight(weight = 1f, fill = true),
            onClick = {}
          )
        }
      }
    }
  }
}
