package com.paligot.movies.presentation.slides

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import com.paligot.kighlighter.components.kotlin.Kotlin
import com.paligot.kighlighter.compose.Kighlighter
import com.paligot.kighlighter.palettes.Palettes
import com.paligot.movies.presentation.templates.Idea
import com.paligot.movies.theming.ExploringMoviesTheme

@Composable
fun Slide18() {
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
  Column {
    Text(
      text = title,
      style = MaterialTheme.typography.h6,
      maxLines = 2,
      overflow = TextOverflow.Ellipsis
    )
  }
}""",
                language = Kotlin(palette = Palettes.Darcula),
                linesHighlighted = arrayListOf(10)
            )
        },
        preview = {
            ExploringMoviesTheme(isDarkMode = true) {
                Column {
                    Text(
                        text = "Joker",
                        style = MaterialTheme.typography.h6,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
        }
    )
}
