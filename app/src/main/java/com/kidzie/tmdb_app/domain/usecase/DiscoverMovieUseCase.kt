package com.kidzie.tmdb_app.domain.usecase

import com.kidzie.tmdb_app.core.BaseUseCaseNoParam
import com.kidzie.tmdb_app.core.Result
import com.kidzie.tmdb_app.data.model.Movie
import com.kidzie.tmdb_app.domain.repository.MovieRepository


class DiscoverMovieUseCase(private val movieRepository: MovieRepository) : BaseUseCaseNoParam<Result<List<Movie>>>() {
    override suspend fun invoke(): Result<List<Movie>> {
        return movieRepository.getDiscoverMovies()
    }
}
