package com.paligot.movies.data

import com.paligot.movies.data.models.Actor
import com.paligot.movies.data.models.Movie
import com.paligot.movies.data.models.MovieDetail
import com.paligot.movies.data.network.Gender
import com.paligot.movies.data.network.MovieItem
import com.paligot.movies.data.network.TheMovieDbService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TheMovieDbRepository(private val apiKey: String): MovieRepository {
  private val service: TheMovieDbService

  init {
    val retrofit = Retrofit.Builder()
      .baseUrl("https://api.themoviedb.org/")
      .client(OkHttpClient.Builder().build())
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
    service = retrofit.create(TheMovieDbService::class.java)
  }

  override suspend fun getPopulars(): List<Movie> {
    val genders = service.getGenders(apiKey)
    val movies = service.getPopulars(apiKey)
    return movies.results.map { it.toMovie(genders.genres) }
  }

  override suspend fun getDailyTrending(): List<Movie> {
    val genders = service.getGenders(apiKey)
    val movies = service.getDailyTrending(apiKey)
    return movies.results.map { it.toMovie(genders.genres) }
  }

  override suspend fun getUpComing(): List<Movie> {
    val genders = service.getGenders(apiKey)
    val movies = service.getUpComing(apiKey)
    return movies.results.map { it.toMovie(genders.genres) }
  }

  override suspend fun getMovieDetail(movieId: Int): MovieDetail {
    val movie = service.getDetailById(movieId, apiKey)
    val genders = service.getGenders(apiKey)
    return MovieDetail(
      id = movie.id,
      title = movie.title,
      overview = movie.overview,
      backdrop = "https://image.tmdb.org/t/p/w780${movie.backdrop}",
      poster = "https://image.tmdb.org/t/p/w185${movie.poster}",
      voteAverage = (movie.voteAverage * 10).toInt(),
      genres = movie.genres.map { it.name },
      releaseDate = movie.releaseDate,
      runtime = movie.runtime,
      actors = service.getCreditById(movieId, apiKey).cast.map {
        Actor(
          it.name,
          it.character,
          "https://image.tmdb.org/t/p/w185${it.profile}"
        )
      },
      recommendations = service.getRecommendationsById(movieId, apiKey).results.map { it.toMovie(genders.genres) },
      similar = service.getSimilarById(movieId, apiKey).results.map { it.toMovie(genders.genres) }
    )
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