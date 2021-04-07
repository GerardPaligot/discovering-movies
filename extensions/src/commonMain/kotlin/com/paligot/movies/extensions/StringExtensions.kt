package com.paligot.movies.extensions

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun String.getYear(): Int =
  Instant.parse("${this}T00:00:00Z").toLocalDateTime(TimeZone.currentSystemDefault()).year