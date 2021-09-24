package com.paligot.movies.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.paligot.movies.presentation.slides.*

@ExperimentalComposeUiApi
fun main(args: Array<String>) = application {
    var navigation by remember { mutableStateOf(0) }
    Window(
        onCloseRequest = ::exitApplication,
        onKeyEvent = {
            return@Window if (it.type == KeyEventType.KeyUp)
                when (it.key) {
                    Key.DirectionRight -> {
                        navigation = navigation + 1
                        true
                    }
                    Key.DirectionLeft -> {
                        navigation = navigation - 1
                        true
                    }
                    else -> false
                }
            else {
                false
            }
        }
    ) {
        when (navigation) {
            0 -> Slide14()
            1 -> Slide15()
            2 -> Slide16()
            3 -> Slide17()
            4 -> Slide18()
            5 -> Slide19()
            6 -> Slide20()
            7 -> Slide21()
            8 -> Slide22()
        }
    }
}

