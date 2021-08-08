package com.paligot.movies.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paligot.movies.theming.ExploringMoviesTheme

@Preview
@Composable
fun MovieMetadataPreview() {
    ExploringMoviesTheme(isDarkMode = true) {
        Surface(modifier = Modifier.fillMaxSize()) {
            MovieMetadata(
                    title = "The Mandalorian",
                    genres = arrayListOf("Crime", "Thriller", "Drama"),
                    releaseDate = "2019-10-02",
                    runtime = 120,
                    modifier = Modifier
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .wrapContentHeight(align = Alignment.CenterVertically)
            )
        }
    }
}
