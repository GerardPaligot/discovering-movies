package com.paligot.movies.data.network

data class Gender(val id: Int, val name: String)
data class MovieGenders(val genres: List<Gender>)