package com.paligot.movies.data.network

import com.paligot.movies.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Path

const val API_KEY = BuildConfig.THE_MOVIE_DB_API_KEY

interface TheMovieDbService {
  @GET("/3/discover/movie?api_key=$API_KEY&sort_by=popularity.desc")
  suspend fun getPopulars(): MovieList

  @GET("/3/trending/movie/day?api_key=$API_KEY")
  suspend fun getDailyTrending(): MovieList

  @GET("/3/movie/upcoming?api_key=$API_KEY")
  suspend fun getUpComing(): MovieList

  @GET("/3/movie/{movieId}?api_key=$API_KEY")
  suspend fun getDetailById(@Path("movieId") movieId: Int): MovieDetail

  @GET("/3/movie/{movieId}/credits?api_key=$API_KEY")
  suspend fun getCreditById(@Path("movieId") movieId: Int): MovieCredit

  @GET("/3/movie/{movieId}/recommendations?api_key=$API_KEY")
  suspend fun getRecommendationsById(@Path("movieId") movieId: Int): MovieList

  @GET("/3/movie/{movieId}/similar?api_key=$API_KEY")
  suspend fun getSimilarById(@Path("movieId") movieId: Int): MovieList

  @GET("/3/genre/movie/list?api_key=$API_KEY")
  suspend fun getGenders( ): MovieGenders
}