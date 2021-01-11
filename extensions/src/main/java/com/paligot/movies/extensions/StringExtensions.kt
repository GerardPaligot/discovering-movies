package com.paligot.movies.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(formatter: String = "yyyy-MM-dd"): Calendar {
  val calendar = Calendar.getInstance()
  val parser = SimpleDateFormat(formatter, Locale.getDefault())
  calendar.time = parser.parse(this)!!
  return calendar
}