package com.paligot.movies.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDbService {
  @GET("/3/discover/movie?sort_by=popularity.desc")
  suspend fun getPopulars(@Query("api_key") apiKey: String): MovieList

  @GET("/3/trending/movie/day")
  suspend fun getDailyTrending(@Query("api_key") apiKey: String): MovieList

  @GET("/3/movie/upcoming")
  suspend fun getUpComing(@Query("api_key") apiKey: String): MovieList

  @GET("/3/movie/{movieId}")
  suspend fun getDetailById(@Path("movieId") movieId: Int, @Query("api_key") apiKey: String): MovieDetail

  @GET("/3/movie/{movieId}/credits")
  suspend fun getCreditById(@Path("movieId") movieId: Int, @Query("api_key") apiKey: String): MovieCredit

  @GET("/3/movie/{movieId}/recommendations")
  suspend fun getRecommendationsById(@Path("movieId") movieId: Int, @Query("api_key") apiKey: String): MovieList

  @GET("/3/movie/{movieId}/similar")
  suspend fun getSimilarById(@Path("movieId") movieId: Int, @Query("api_key") apiKey: String): MovieList

  @GET("/3/genre/movie/list")
  suspend fun getGenders(@Query("api_key") apiKey: String): MovieGenders
}