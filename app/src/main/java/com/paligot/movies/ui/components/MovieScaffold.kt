package com.paligot.movies.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.paligot.movies.theming.ExploringMoviesTheme

@Composable
fun MovieScaffold(
  title: String = "Exploring Movies",
  content: @Composable() () -> Unit
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text(text = title) },
        backgroundColor = MaterialTheme.colors.primary,
      )
    },
    content = { content() }
  )
}

@Preview
@Composable
fun MovieScaffoldPreview() {
  ExploringMoviesTheme {
    MovieScaffold {
    }
  }
}