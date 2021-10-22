package com.paligot.movies.theming

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
actual fun Font(res: String, weight: FontWeight, style: FontStyle): Font {
    val context = LocalContext.current
    val fontName = res.split("/").last().split(".").first()
    val id = context.resources.getIdentifier(fontName, "font", context.packageName)
    return Font(id, weight, style)
}
