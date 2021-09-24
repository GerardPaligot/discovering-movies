package com.paligot.movies.presentation.slides

import androidx.compose.runtime.Composable
import com.paligot.kighlighter.components.kotlin.Kotlin
import com.paligot.kighlighter.compose.Kighlighter
import com.paligot.kighlighter.palettes.Palettes
import com.paligot.movies.presentation.templates.Idea
import com.paligot.movies.theming.ExploringMoviesTheme

@Composable
fun Slide14() {
    Idea(
        code = {
            Kighlighter(
                snippet = """
@Composable
fun MovieMetadata(
  title: String,
  genres: List<String>,
  releaseDate: String,
  runtime: Int,
  modifier: Modifier = Modifier
) {
}""",
                language = Kotlin(palette = Palettes.Darcula)
            )
        },
        preview = {
            ExploringMoviesTheme(isDarkMode = true) {
            }
        }
    )
}