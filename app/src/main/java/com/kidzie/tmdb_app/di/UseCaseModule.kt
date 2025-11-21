package com.kidzie.tmdb_app.di

import com.kidzie.tmdb_app.domain.repository.MovieRepository
import com.kidzie.tmdb_app.domain.usecase.DiscoverMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideDiscoverMovieUseCase(movieRepository: MovieRepository): DiscoverMovieUseCase {
        return DiscoverMovieUseCase(movieRepository)
    }
}