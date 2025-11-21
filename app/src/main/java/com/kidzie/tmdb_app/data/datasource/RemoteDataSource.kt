package com.kidzie.tmdb_app.data.datasource

import com.kidzie.tmdb_app.data.model.Movie

interface RemoteDataSource {
    suspend fun getDiscoverMovies(): List<Movie>
}