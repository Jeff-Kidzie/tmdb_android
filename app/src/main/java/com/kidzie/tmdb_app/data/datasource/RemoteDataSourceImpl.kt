package com.kidzie.tmdb_app.data.datasource

import com.kidzie.tmdb_app.data.model.Movie
import com.kidzie.tmdb_app.service.ApiService

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource{

    override suspend fun getDiscoverMovies(): List<Movie> {
        return apiService.getDiscoverMovies()
    }
}