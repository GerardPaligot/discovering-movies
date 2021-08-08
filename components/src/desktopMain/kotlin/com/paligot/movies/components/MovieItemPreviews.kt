package com.paligot.movies.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paligot.movies.theming.ExploringMoviesTheme

@Preview
@Composable
fun MovieItemPreview() {
    ExploringMoviesTheme(isDarkMode = true) {
        MovieItem(
                title = "The Mandalorian",
                pictureUrl = "",
                rating = 87,
                genres = arrayListOf("Crime", "Thriller", "Drama"),
                releaseDate = "2019-10-02",
                runtime = 120,
                modifier = Modifier
                        .wrapContentSize(align = Alignment.Center)
                        .padding(start = 10.dp, end = 10.dp)
        ) {}
    }
}