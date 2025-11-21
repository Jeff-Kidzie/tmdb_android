package com.kidzie.tmdb_app.domain.usecase

import com.kidzie.tmdb_app.core.BaseUseCase
import com.kidzie.tmdb_app.domain.repository.MovieRepository

class DiscoverMovieUseCase(private val movieRepository: MovieRepository) : BaseUseCase() {
    override suspend fun execute() {
        movieRepository.getDiscoverMovies()
    }
}