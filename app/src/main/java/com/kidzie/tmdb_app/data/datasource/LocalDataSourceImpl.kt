package com.kidzie.tmdb_app.data.datasource

import com.kidzie.tmdb_app.data.model.Movie

class LocalDataSourceImpl : LocalDataSource {
    override suspend fun loadLocalDiscoveryMovies(): List<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun saveLocalDiscoveryMovies(movies: List<Movie>) {
        TODO("Not yet implemented")
    }
}