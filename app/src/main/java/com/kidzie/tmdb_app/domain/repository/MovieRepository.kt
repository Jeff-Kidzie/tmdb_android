package com.kidzie.tmdb_app.domain.repository

import com.kidzie.tmdb_app.data.datasource.LocalDataSource
import com.kidzie.tmdb_app.data.datasource.RemoteDataSource

interface MovieRepository : LocalDataSource, RemoteDataSource