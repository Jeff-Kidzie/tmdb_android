package com.kidzie.tmdb_app.service

import com.kidzie.tmdb_app.data.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun getDiscoverMovies(): List<Movie>
}