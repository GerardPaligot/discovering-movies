package com.paligot.movies.data.network

import com.squareup.moshi.Json

data class MovieItem(
  val id: Int,
  val title: String,
  val overview: String,
  @field:Json(name = "genre_ids") val genreIds: List<Int>,
  val popularity: Float,
  @field:Json(name = "release_date") val releaseDate: String,
  @field:Json(name = "vote_average") val voteAverage: Float,
  @field:Json(name = "vote_count") val voteCount: Int,
  @field:Json(name = "backdrop_path") val backdrop: String,
  @field:Json(name = "poster_path") val poster: String,
  @field:Json(name = "original_title") val originalTitle: String,
  @field:Json(name = "original_language") val originalLanguage: String,
  val adult: Boolean,
  val video: Boolean
)

data class MovieList(
  val page: Int,
  @field:Json(name = "total_results") val total: Int,
  @field:Json(name = "total_pages") val pages: Int,
  val results: List<MovieItem>
)