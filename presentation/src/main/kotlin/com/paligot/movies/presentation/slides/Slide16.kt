package com.paligot.movies.presentation.slides

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.paligot.kighlighter.components.kotlin.Kotlin
import com.paligot.kighlighter.compose.Kighlighter
import com.paligot.kighlighter.palettes.Palettes
import com.paligot.movies.presentation.templates.Idea
import com.paligot.movies.theming.ExploringMoviesTheme

@Composable
fun Slide16() {
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
  Text(
    text = title,
    style = MaterialTheme.typography.h6
  )
}""",
                language = Kotlin(palette = Palettes.Darcula),
                linesHighlighted = arrayListOf(12)
            )
        },
        preview = {
            ExploringMoviesTheme(isDarkMode = true) {
                Text(
                    text = "Joker",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    )
}
