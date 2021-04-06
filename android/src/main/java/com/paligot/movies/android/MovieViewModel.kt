package com.paligot.movies.android

import androidx.lifecycle.ViewModel
import com.paligot.movies.data.MovieRepository
import kotlinx.coroutines.flow.flow

const val API_KEY = BuildConfig.THE_MOVIE_DB_API_KEY

class MovieViewModel : ViewModel() {
  private val repository = MovieRepository.Factory.newInstance(API_KEY)

  fun getPopulars() = flow {
    emit(repository.getPopulars())
  }

  fun getDailyTrending() = flow {
    emit(repository.getDailyTrending())
  }

  fun getUpComing() = flow {
    emit(repository.getUpComing())
  }

  fun getMovieDetail(movieId: Int) = flow {
    emit(repository.getMovieDetail(movieId))
  }
}
