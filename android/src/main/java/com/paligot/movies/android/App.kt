package com.paligot.movies.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.paligot.movies.data.models.MovieSection
import com.paligot.movies.theming.ExploringMoviesTheme
import com.paligot.movies.android.screens.MovieDetailsViewModel
import com.paligot.movies.android.screens.MovieHomeViewModel
import com.paligot.movies.android.screens.MovieListViewModel

@Composable
fun App(
  homeScreenOpened: () -> Unit = {},
  movieDetailScreenOpened: () -> Unit = {},
  movieListScreenOpened: () -> Unit = {}
) {
  val navController = rememberNavController()
  LaunchedEffect(Unit) {
    navController.addOnDestinationChangedListener { _, dest, _ ->
      when (dest.route) {
        "movies" -> homeScreenOpened()
        "movies/{movieId}" -> movieDetailScreenOpened()
        "sections/{sectionId}" -> movieListScreenOpened()
        else -> TODO()
      }
    }
  }
  Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
    NavHost(navController, startDestination = "movies") {
      composable("movies") {
        MovieHomeViewModel(
          onViewAllClick = {
            navController.navigate("sections/$it")
          }
        ) { navController.navigate("movies/${it.id}") }
      }
      composable(
        route = "sections/{sectionId}",
        arguments = listOf(navArgument("sectionId") {
          type = NavType.EnumType(MovieSection::class.java)
        })
      ) {
        MovieListViewModel(
          movieSection = it.arguments?.get("sectionId")!! as MovieSection
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
    App()
  }
}