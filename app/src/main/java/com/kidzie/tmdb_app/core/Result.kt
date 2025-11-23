package com.kidzie.tmdb_app.core

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: Exception, val errorMessage : String) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}