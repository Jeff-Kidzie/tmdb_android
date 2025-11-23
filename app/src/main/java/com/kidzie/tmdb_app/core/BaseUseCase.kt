package com.kidzie.tmdb_app.core

abstract class BaseUseCase<Param,T> {
    abstract suspend operator fun invoke(param : Param) : T
}

abstract class BaseUseCaseNoParam<T> {
    abstract suspend operator fun invoke() : T
}