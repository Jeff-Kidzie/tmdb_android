package com.kidzie.tmdb_app.domain.repository

import com.kidzie.tmdb_app.data.datasource.LocalDataSource
import com.kidzie.tmdb_app.data.datasource.RemoteDataSource
import com.kidzie.tmdb_app.data.model.Movie

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MovieRepository, RemoteDataSource by remoteDataSource, LocalDataSource by localDataSource {

//    override suspend fun getDiscoverMovies(): Result<List<Movie>> {
//        return remoteDataSource.getDiscoverMovies()
//    }
}