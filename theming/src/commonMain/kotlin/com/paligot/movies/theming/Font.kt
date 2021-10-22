package com.paligot.movies.theming

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
expect fun Font(res: String, weight: FontWeight, style: FontStyle): Font

object Fonts {
    val roboto: FontFamily
        @Composable
        get() = FontFamily(
            Font(
                "font/roboto_black.ttf",
                FontWeight.Black,
                FontStyle.Normal
            ),
            Font(
                "font/roboto_black_italic.ttf",
                FontWeight.Black,
                FontStyle.Italic
            ),
            Font(
                "font/roboto_bold.ttf",
                FontWeight.Bold,
                FontStyle.Normal
            ),
            Font(
                "font/roboto_bold_italic.ttf",
                FontWeight.Bold,
                FontStyle.Italic
            ),
            Font(
                "font/roboto_italic.ttf",
                FontWeight.Normal,
                FontStyle.Italic
            ),
            Font(
                "font/roboto_light.ttf",
                FontWeight.Light,
                FontStyle.Normal
            ),
            Font(
                "font/roboto_light_italic.ttf",
                FontWeight.Light,
                FontStyle.Italic
            ),
            Font(
                "font/roboto_medium.ttf",
                FontWeight.Medium,
                FontStyle.Normal
            ),
            Font(
                "font/roboto_medium_italic.ttf",
                FontWeight.Medium,
                FontStyle.Italic
            ),
            Font(
                "font/roboto_regular.ttf",
                FontWeight.Normal,
                FontStyle.Normal
            ),
            Font(
                "font/roboto_thin.ttf",
                FontWeight.Thin,
                FontStyle.Normal
            ),
            Font(
                "font/roboto_thin_italic.ttf",
                FontWeight.Thin,
                FontStyle.Italic
            ),
        )
}