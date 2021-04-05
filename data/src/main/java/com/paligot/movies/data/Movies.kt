package com.paligot.movies.data

data class Movie(
  val id: Int = 0,
  val title: String, val pictureUrl: String, val percentage: Int,
  val genres: List<String>,
  val releaseDate: String,
  val runtime: Int
)

data class Actor(
  val name: String,
  val character: String,
  val profilePath: String
)

data class MovieDetail(
  val id: Int = 0,
  val title: String,
  val overview: String,
  val backdrop: String,
  val poster: String,
  val voteAverage: Int,
  val genres: List<String>,
  val releaseDate: String,
  val runtime: Int,
  val actors: List<Actor>,
  val recommendations: List<Movie>,
  val similar: List<Movie>
)
