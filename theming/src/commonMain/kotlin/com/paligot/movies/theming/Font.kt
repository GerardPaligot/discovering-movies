package com.paligot.movies.theming

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
expect fun Font(fontName: String, weight: FontWeight, style: FontStyle): Font

object Fonts {
    val roboto: FontFamily
        @Composable
        get() = FontFamily(
            Font(
                "roboto_black",
                FontWeight.Black,
                FontStyle.Normal
            ),
            Font(
                "roboto_black_italic",
                FontWeight.Black,
                FontStyle.Italic
            ),
            Font(
                "roboto_bold",
                FontWeight.Bold,
                FontStyle.Normal
            ),
            Font(
                "roboto_bold_italic",
                FontWeight.Bold,
                FontStyle.Italic
            ),
            Font(
                "roboto_italic",
                FontWeight.Normal,
                FontStyle.Italic
            ),
            Font(
                "roboto_light",
                FontWeight.Light,
                FontStyle.Normal
            ),
            Font(
                "roboto_light_italic",
                FontWeight.Light,
                FontStyle.Italic
            ),
            Font(
                "roboto_medium",
                FontWeight.Medium,
                FontStyle.Normal
            ),
            Font(
                "roboto_medium_italic",
                FontWeight.Medium,
                FontStyle.Italic
            ),
            Font(
                "roboto_regular",
                FontWeight.Normal,
                FontStyle.Normal
            ),
            Font(
                "roboto_thin",
                FontWeight.Thin,
                FontStyle.Normal
            ),
            Font(
                "roboto_thin_italic",
                FontWeight.Thin,
                FontStyle.Italic
            ),
        )
}