package com.paligot.movies.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.paligot.movies.theming.ExploringMoviesTheme

@Preview
@Composable
fun PosterPreview() {
    ExploringMoviesTheme(isDarkMode = true) {
        Poster(pictureUrl = "")
    }
}
