package com.kidzie.tmdb_app.data.datasource

import com.kidzie.tmdb_app.core.Result
import com.kidzie.tmdb_app.data.model.Movie
import com.kidzie.tmdb_app.service.ApiService

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource{

    override suspend fun getDiscoverMovies(): Result<List<Movie>> {
        return try {
            val movies = apiService.getDiscoverMovies()
            Result.Success(movies)
        } catch (e : Exception) {
            Result.Error(e, e.message ?: "Unknown error")
        }
    }
}