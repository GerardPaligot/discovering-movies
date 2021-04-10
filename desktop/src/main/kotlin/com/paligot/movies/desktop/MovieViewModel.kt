package com.paligot.movies.desktop

import com.paligot.movies.data.MovieRepository
import kotlinx.coroutines.flow.flow

class MovieViewModel(apiKey: String) {
  private val repository = MovieRepository.Factory.newInstance(apiKey)

  fun getPopulars() = flow {
    emit(repository.getPopulars())
  }

  fun getDailyTrending() = flow {
    emit(repository.getDailyTrending())
  }

  fun getUpComing() = flow {
    emit(repository.getUpComing())
  }
}
