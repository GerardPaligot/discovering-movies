package com.paligot.movies.extensions

import android.graphics.Color
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorInt

fun Window.makeStatusBarTransparent() {
  clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
  addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
  decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
  statusBarColor = Color.TRANSPARENT
}

fun Window.changeStatusBarColor(@ColorInt color: Int) {
  clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
  decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
  statusBarColor = color
}
