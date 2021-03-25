package com.paligot.movies

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.paligot.movies.extensions.changeStatusBarColor
import com.paligot.movies.extensions.legacy
import com.paligot.movies.extensions.makeStatusBarTransparent
import com.paligot.movies.theming.ExploringMoviesTheme
import com.paligot.movies.ui.components.App

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val isSystemDark = isSystemInDarkTheme()
      val isDarkModeState = remember { mutableStateOf(isSystemDark) }
      ExploringMoviesTheme(isDarkMode = isDarkModeState.value) {
        val legacyPrimaryColor = MaterialTheme.colors.primary.legacy()
        App(
          isDarkModeActive = isDarkModeState.value,
          homeScreenOpened = {
            window.changeStatusBarColor(legacyPrimaryColor)
          },
          movieListScreenOpened = {
            window.changeStatusBarColor(legacyPrimaryColor)
          },
          movieDetailScreenOpened = {
            window.makeStatusBarTransparent()
          },
          switchDarkMode = {
            isDarkModeState.value = !isDarkModeState.value
          }
        )
      }
    }
  }
}