package com.paligot.movies.theming

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
  primary = orange900,
  primaryVariant = orange800,
  secondary = blue400,
  background = Color.White,
  surface = Color.White,
  onPrimary = Color.White,
  onSecondary = Color.Black,
  onBackground = Color.Black,
  onSurface = Color.Black,
)

private val DarkColorPalette = darkColors(
  primary = blue900,
  primaryVariant = blue800,
  secondary = orange400,
  background = grayDark,
  surface = grayDark,
  onPrimary = Color.White,
  onSecondary = Color.Black,
  onBackground = Color.White,
  onSurface = Color.White
)

@Composable
expect fun isSystemInDarkTheme(): Boolean

@Composable
fun ExploringMoviesTheme(
  isDarkMode: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  MaterialTheme(
    colors = if (isDarkMode) DarkColorPalette else LightColorPalette,
    typography = typography,
    shapes = shapes,
    content = content
  )
}