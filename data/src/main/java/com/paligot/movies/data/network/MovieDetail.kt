package com.paligot.movies.data.network

import com.squareup.moshi.Json

data class ProductionCompany(
  val id: Int,
  @field:Json(name = "logo_path") val logo: String,
  val name: String,
  @field:Json(name = "origin_country") val country: String
)

data class Country(
  @field:Json(name = "iso_3166_1") val countryCode: String,
  val name: String
)

data class MovieDetail(
  val id: Int,
  val title: String,
  val overview: String,
  val tagline: String,
  val homepage: String,
  val genres: List<Gender>,
  val popularity: Float,
  val budget: Long,
  val revenue: Long,
  val runtime: Int,
  val status: String,
  @field:Json(name = "release_date") val releaseDate: String,
  @field:Json(name = "vote_average") val voteAverage: Float,
  @field:Json(name = "vote_count") val voteCount: Int,
  @field:Json(name = "backdrop_path") val backdrop: String,
  @field:Json(name = "poster_path") val poster: String,
  @field:Json(name = "original_title") val originalTitle: String,
  @field:Json(name = "original_language") val originalLanguage: String,
  @field:Json(name = "spoken_languages") val spokenLanguages: List<Country>,
  @field:Json(name = "production_companies") val productionCompanies: List<ProductionCompany>,
  @field:Json(name = "production_countries") val productionCountries: List<Country>,
  val adult: Boolean,
  val video: Boolean
)