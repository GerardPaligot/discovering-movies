package com.paligot.movies.theming.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paligot.movies.theming.green900
import com.paligot.movies.theming.greenDark
import com.paligot.movies.theming.orange900
import com.paligot.movies.theming.red900

@Composable
fun Rating(
  percentage: Int,
  modifier: Modifier = Modifier
) {
  BoxWithConstraints {
    val boxWidth = with(LocalDensity.current) { constraints.maxWidth.toDp() }
    val boxHeight = with(LocalDensity.current) { constraints.maxHeight.toDp() }
    val largestSize = if (boxWidth.value > boxHeight.value) boxHeight else boxWidth
    Surface(
      modifier = modifier.size(largestSize),
      shape = CircleShape,
      color = greenDark
    ) {
      Box {
        val strokeWidth = 0.08f * largestSize.value
        val padding = 0.03 * largestSize.value
        val stroke = Stroke(strokeWidth)
        Canvas(modifier = Modifier.padding(padding.dp).fillMaxSize()) {
          val diameter = size.minDimension
          val radius = diameter / 2f
          val insideRadius = radius - stroke.width
          val topLeftOffset = Offset(strokeWidth, strokeWidth)
          val size = Size(insideRadius * 2, insideRadius * 2)
          val sweepAngle = (percentage / 100f) * 360f
          drawArc(
            color = if (percentage >= 70) green900 else if (percentage >= 30) orange900 else red900,
            startAngle = -90f,
            sweepAngle = sweepAngle,
            topLeft = topLeftOffset,
            size = size,
            useCenter = false,
            style = stroke,
          )
          drawArc(
            color = if (percentage >= 70) green900.copy(alpha = 0.3f) else if (percentage >= 30) orange900.copy(alpha = 0.3f) else red900.copy(alpha = 0.3f),
            startAngle = sweepAngle - 90f,
            sweepAngle = 360f - sweepAngle,
            topLeft = topLeftOffset,
            size = size,
            useCenter = false,
            style = stroke
          )
        }
        Box(modifier = Modifier
          .fillMaxSize()
          .wrapContentSize(align = Alignment.Center)) {
          val fontSize = 0.34f * largestSize.value
          Text(
            text = "$percentage",
            style = MaterialTheme.typography.button.copy(fontSize = fontSize.sp),
            color = Color.White
          )
        }
      }
    }
  }
}

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