package com.paligot.movies.components

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.paligot.movies.theming.ExploringMoviesTheme

@Preview
@Composable
fun PosterPreview() {
    ExploringMoviesTheme(isDarkMode = true) {
        Poster(
                pictureUrl = ""
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PosterNotedPreview() {
    ExploringMoviesTheme(isDarkMode = true) {
        PosterNoted(
                posterUrl = "",
                voteAverage = 79,
                ratingAlignment = Alignment.TopEnd
        )
    }
}
