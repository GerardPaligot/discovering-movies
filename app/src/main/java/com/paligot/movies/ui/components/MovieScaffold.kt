package com.paligot.movies.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.paligot.movies.R
import com.paligot.movies.ui.ExploringMoviesTheme

@Composable
fun MovieScaffold(
  title: String = "Exploring Movies",
  isDarkModeActive: Boolean,
  switchDarkMode: () -> Unit = {},
  content: @Composable () -> Unit
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text(text = title) },
        backgroundColor = MaterialTheme.colors.primary,
        actions = {
          IconButton(onClick = switchDarkMode) {
            val imageId = if (isDarkModeActive) R.drawable.ic_sun else R.drawable.ic_moon
            val image = loadVectorResource(id = imageId)
            image.resource.resource?.let {
              Icon(imageVector = it)
            }
          }
        }
      )
    },
  ) {
    content()
  }
}

@Preview
@Composable
fun MovieScaffoldPreview() {
  ExploringMoviesTheme {
    MovieScaffold(isDarkModeActive = true) {
    }
  }
}