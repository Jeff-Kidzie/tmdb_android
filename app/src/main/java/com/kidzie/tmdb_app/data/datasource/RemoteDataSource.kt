package com.kidzie.tmdb_app.data.datasource

import com.kidzie.tmdb_app.core.Result
import com.kidzie.tmdb_app.data.model.Movie

interface RemoteDataSource {
    suspend fun getDiscoverMovies(): Result<List<Movie>>
}