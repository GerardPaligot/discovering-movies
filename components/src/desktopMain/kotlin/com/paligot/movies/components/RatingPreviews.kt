package com.paligot.movies.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun RatingGreenPreview() {
    Rating(80, modifier = Modifier.size(100.dp))
}

@Preview
@Composable
fun RatingOrangePreview() {
    Rating(54, modifier = Modifier.size(80.dp))
}

@Preview
@Composable
fun RatingRedPreview() {
    Rating(22, modifier = Modifier.size(50.dp))
}