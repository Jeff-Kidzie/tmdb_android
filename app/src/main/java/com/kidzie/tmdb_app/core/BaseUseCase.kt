package com.kidzie.tmdb_app.core

abstract class BaseUseCase {
    abstract suspend fun execute()
}