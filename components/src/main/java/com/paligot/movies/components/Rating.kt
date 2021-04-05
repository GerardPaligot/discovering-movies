package com.paligot.movies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
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
  val color = if (percentage >= 70) green900 else if (percentage >= 30) orange900 else red900
  BoxWithConstraints(
    modifier = modifier
      .fillMaxWidth()
      .aspectRatio(1f)
      .clip(CircleShape)
      .background(color = greenDark, shape = CircleShape)
      .drawBehind {
        val largestSize = if (size.width > size.height) size.height else size.width
        val strokeWidth = 0.05f * largestSize
        val padding = 0.07f * largestSize
        val sweepAngle = (percentage / 100f) * 360f
        val topLeft = Offset(x = padding, y = padding)
        val topLeftSize = Size(size.width - (padding * 2), size.height - (padding * 2))
        drawArc(
          color = color.copy(alpha = 0.3f),
          startAngle = -90f,
          sweepAngle = 360f,
          topLeft = topLeft,
          size = topLeftSize,
          useCenter = false,
          style = Stroke(strokeWidth),
        )
        drawArc(
          color = color,
          startAngle = -90f,
          sweepAngle = 360f - sweepAngle,
          useCenter = false,
          style = Stroke(strokeWidth, cap = StrokeCap.Round),
          topLeft = topLeft,
          size = topLeftSize
        )
      }
      .wrapContentSize(align = Alignment.Center),
    content = {
      val largestSize = if (maxWidth > maxHeight) maxHeight else maxWidth
      val fontSize = 0.34f * largestSize.value
      Text(
        text = "$percentage",
        style = MaterialTheme.typography.button.copy(fontSize = fontSize.sp),
        color = Color.White
      )
    }
  )
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