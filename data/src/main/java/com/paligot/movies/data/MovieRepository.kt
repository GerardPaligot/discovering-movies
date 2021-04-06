package com.paligot.movies.data

import com.paligot.movies.data.models.Movie
import com.paligot.movies.data.models.MovieDetail

interface MovieRepository {
  suspend fun getPopulars(): List<Movie>
  suspend fun getDailyTrending(): List<Movie>
  suspend fun getUpComing(): List<Movie>
  suspend fun getMovieDetail(movieId: Int): MovieDetail

  object Factory {
    fun newInstance(apiKey: String): MovieRepository {
      return TheMovieDbRepository(apiKey)
    }
  }
}