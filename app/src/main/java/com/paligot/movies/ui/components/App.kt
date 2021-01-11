package com.paligot.movies.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.paligot.movies.theming.ExploringMoviesTheme

enum class MovieSection {
  UPCOMING, POPULAR, TRENDING
}

@Composable
fun App(
  isDarkModeActive: Boolean,
  homeScreenOpened: () -> Unit = {},
  movieDetailScreenOpened: () -> Unit = {},
  movieListScreenOpened: () -> Unit = {},
  switchDarkMode: () -> Unit
) {
  val navController = rememberNavController()
  navController.addOnDestinationChangedListener { _, _, arguments ->
    when (arguments?.get("android-support-nav:controller:route")) {
      "movies" -> homeScreenOpened()
      "movies/{movieId}" -> movieDetailScreenOpened()
      "sections/{sectionId}" -> movieListScreenOpened()
      else -> TODO()
    }
  }
  Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
    NavHost(navController, startDestination = "movies") {
      composable("movies") {
        MovieHomeViewModel(
          isDarkModeActive = isDarkModeActive,
          onViewAllClick = {
            navController.navigate("sections/$it")
          },
          onClick = { navController.navigate("movies/${it.id}") },
          switchDarkMode = switchDarkMode
        )
      }
      composable(
        route = "sections/{sectionId}",
        arguments = listOf(navArgument("sectionId") {
          type = NavType.EnumType(MovieSection::class.java)
        })
      ) {
        MovieListViewModel(
          movieSection = it.arguments?.get("sectionId")!! as MovieSection,
          isDarkModeActive = isDarkModeActive,
          switchDarkMode = switchDarkMode
        ) {
          navController.navigate("movies/${it.id}")
        }
      }
      composable(
        route = "movies/{movieId}",
        arguments = listOf(navArgument("movieId") { type = NavType.IntType })
      ) {
        MovieDetailsViewModel(movieId = it.arguments?.getInt("movieId")!!) { movie ->
          navController.navigate("movies/${movie.id}")
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ExploringMoviesTheme {
    App(isDarkModeActive = false) {}
  }
}