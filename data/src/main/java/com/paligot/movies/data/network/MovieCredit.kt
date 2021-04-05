package com.paligot.movies.data.network

import com.squareup.moshi.Json

data class Cast(
  val order: Int,
  val id: Int,
  @field:Json(name = "cast_id") val castId: Int,
  @field:Json(name = "credit_id") val creditId: String,
  val gender: Int,
  val name: String,
  val character: String,
  @field:Json(name = "profile_path") val profile: String
)

data class Crew(
  val id: Int,
  @field:Json(name = "credit_id") val creditId: String,
  val gender: Int,
  val name: String,
  val department: String,
  val job: String,
  @field:Json(name = "profile_path") val profile: String
)

data class MovieCredit(
  val id: Int,
  val cast: List<Cast>,
  val crew: List<Crew>
)
