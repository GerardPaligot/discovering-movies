package com.paligot.movies.presentation.slides

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.paligot.kighlighter.components.kotlin.Kotlin
import com.paligot.kighlighter.compose.Kighlighter
import com.paligot.kighlighter.palettes.Palettes
import com.paligot.movies.presentation.templates.Idea
import com.paligot.movies.theming.ExploringMoviesTheme
import com.paligot.movies.components.Tag

@Composable
fun Slide22() {
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
    Text(...)
    Row(modifier = Modifier.padding(top = 5.dp)) {
      genres.forEach {
        Tag(text = it)
      }
    }
  }
}""",
                language = Kotlin(palette = Palettes.Darcula),
                linesHighlighted = arrayListOf(12)
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
                    Row(modifier = Modifier.padding(top = 5.dp)) {
                        listOf("Crime", "Thriller", "Drama").forEach {
                            Tag(text = it)
                        }
                    }
                }
            }
        }
    )
}
