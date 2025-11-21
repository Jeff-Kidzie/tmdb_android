package com.kidzie.tmdb_app.di

import com.kidzie.tmdb_app.data.datasource.LocalDataSource
import com.kidzie.tmdb_app.data.datasource.RemoteDataSource
import com.kidzie.tmdb_app.domain.repository.MovieRepository
import com.kidzie.tmdb_app.domain.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieRepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource, localDataSource)
    }
}
