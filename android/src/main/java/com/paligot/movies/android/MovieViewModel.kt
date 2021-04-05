package com.paligot.movies.android

import androidx.lifecycle.ViewModel
import com.paligot.movies.data.Actor
import com.paligot.movies.data.Movie
import com.paligot.movies.data.MovieDetail
import com.paligot.movies.data.network.Gender
import com.paligot.movies.data.network.MovieItem
import com.paligot.movies.data.network.TheMovieDbService
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val API_KEY = BuildConfig.THE_MOVIE_DB_API_KEY

class MovieViewModel : ViewModel() {
  private val service: TheMovieDbService

  init {
    val retrofit = Retrofit.Builder()
      .baseUrl("https://api.themoviedb.org/")
      .client(OkHttpClient.Builder().build())
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
    service = retrofit.create(TheMovieDbService::class.java)
  }

  fun getPopulars() = flow {
    val genders = service.getGenders(API_KEY)
    val movies = service.getPopulars(API_KEY)
    emit(movies.results.map { it.toMovie(genders.genres) })
  }

  fun getDailyTrending() = flow {
    val genders = service.getGenders(API_KEY)
    val movies = service.getDailyTrending(API_KEY)
    emit(movies.results.map { it.toMovie(genders.genres) })
  }

  fun getUpComing() = flow {
    val genders = service.getGenders(API_KEY)
    val movies = service.getUpComing(API_KEY)
    emit(movies.results.map { it.toMovie(genders.genres) })
  }

  fun getMovieDetail(movieId: Int) = flow {
    val movie = service.getDetailById(movieId, API_KEY)
    val genders = service.getGenders(API_KEY)
    emit(MovieDetail(
      id = movie.id,
      title = movie.title,
      overview = movie.overview,
      backdrop = "https://image.tmdb.org/t/p/w780${movie.backdrop}",
      poster = "https://image.tmdb.org/t/p/w185${movie.poster}",
      voteAverage = (movie.voteAverage * 10).toInt(),
      genres = movie.genres.map { it.name },
      releaseDate = movie.releaseDate,
      runtime = movie.runtime,
      actors = service.getCreditById(movieId, API_KEY).cast.map {
        Actor(
          it.name,
          it.character,
          "https://image.tmdb.org/t/p/w185${it.profile}"
        )
      },
      recommendations = service.getRecommendationsById(movieId, API_KEY).results.map { it.toMovie(genders.genres) },
      similar = service.getSimilarById(movieId, API_KEY).results.map { it.toMovie(genders.genres) }
    ))
  }
}

private fun MovieItem.toMovie(genres: List<Gender>): Movie = Movie(
  id = this.id,
  title = this.title,
  pictureUrl = "https://image.tmdb.org/t/p/w185${this.poster}",
  percentage = (this.voteAverage * 10).toInt(),
  genres = genres.filter { this.genreIds.contains(it.id) }.map { it.name },
  releaseDate = this.releaseDate,
  runtime = 0
)