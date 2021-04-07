package com.paligot.movies.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

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
