package com.paligot.movies.ui.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.paligot.movies.data.joker
import com.paligot.movies.ui.ExploringMoviesTheme

@Composable
fun Tag(
  text: String,
  modifier: Modifier = Modifier,
  color: Color = Color.Gray
) {
  Text(
    text,
    style = MaterialTheme.typography.overline,
    color = color,
    modifier = modifier
      .border(1.dp, color, RoundedCornerShape(50))
      .padding(horizontal = 10.dp, vertical = 2.dp)
  )
}

@Preview
@Composable
fun TagPreview() {
  ExploringMoviesTheme() {
    Tag(text = joker.genres[0])
  }
}