package com.paligot.movies.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(name = "Green")
@Composable
fun RatingGreenPreview() {
  Rating(80, modifier = Modifier.size(100.dp))
}

@Preview(name = "Orange")
@Composable
fun RatingOrangePreview() {
  Rating(54, modifier = Modifier.size(80.dp))
}

@Preview(name = "Red")
@Composable
fun RatingRedPreview() {
  Rating(22, modifier = Modifier.size(50.dp))
}
