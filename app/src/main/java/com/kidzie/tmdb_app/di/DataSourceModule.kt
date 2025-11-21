package com.kidzie.tmdb_app.di

import com.kidzie.tmdb_app.data.datasource.LocalDataSource
import com.kidzie.tmdb_app.data.datasource.LocalDataSourceImpl
import com.kidzie.tmdb_app.data.datasource.RemoteDataSource
import com.kidzie.tmdb_app.data.datasource.RemoteDataSourceImpl
import com.kidzie.tmdb_app.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(): LocalDataSource {
        return LocalDataSourceImpl()
    }

}