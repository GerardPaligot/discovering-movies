package com.paligot.movies

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberAndroidSystemUiController
import com.paligot.movies.theming.ExploringMoviesTheme
import com.paligot.movies.ui.App

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val isSystemDark = isSystemInDarkTheme()
      val isDarkModeState = remember { mutableStateOf(isSystemDark) }
      val controller = rememberAndroidSystemUiController()
      ExploringMoviesTheme(isDarkMode = isDarkModeState.value) {
        val primaryColor = MaterialTheme.colors.primary
        controller.setStatusBarColor(primaryColor)
        App(
          homeScreenOpened = {
            controller.setStatusBarColor(primaryColor)
          },
          movieListScreenOpened = {
            controller.setStatusBarColor(primaryColor)
          },
          movieDetailScreenOpened = {
            controller.setSystemBarsColor(Color.Transparent)
          }
        )
      }
    }
  }
}