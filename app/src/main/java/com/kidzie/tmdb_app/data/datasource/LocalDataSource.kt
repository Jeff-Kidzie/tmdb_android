package com.kidzie.tmdb_app.data.datasource

import com.kidzie.tmdb_app.data.model.Movie

interface LocalDataSource {
    suspend fun loadLocalDiscoveryMovies(): List<Movie>
    suspend fun saveLocalDiscoveryMovies(movies: List<Movie>)
}