package com.paligot.movies.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paligot.movies.theming.ExploringMoviesTheme

@Preview
@Composable
fun ActorItemPreview() {
  ExploringMoviesTheme() {
    ActorItem(
            name = "Jim Carrey",
            pictureUrl = "",
            modifier = Modifier
                    .padding(5.dp)
                    .width(100.dp)
    )
  }
}