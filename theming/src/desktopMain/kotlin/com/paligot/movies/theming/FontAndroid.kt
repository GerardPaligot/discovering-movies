package com.paligot.movies.theming

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
actual fun Font(fontName: String, weight: FontWeight, style: FontStyle): Font =
    androidx.compose.ui.text.platform.Font("font/${fontName}.ttf", weight, style)
