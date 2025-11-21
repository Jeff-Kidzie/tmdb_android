package com.kidzie.tmdb_app.viewmodel

import androidx.lifecycle.viewModelScope
import com.kidzie.tmdb_app.core.Action
import com.kidzie.tmdb_app.core.ActionResult
import com.kidzie.tmdb_app.core.BaseViewModel
import com.kidzie.tmdb_app.core.ViewState
import com.kidzie.tmdb_app.data.model.Movie
import com.kidzie.tmdb_app.domain.usecase.DiscoverMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val discoverMovieUseCase: DiscoverMovieUseCase) : BaseViewModel<HomeAction, HomeActionResult, HomeViewState>() {

    override fun onAction(action: HomeAction): HomeActionResult {
        return when (action) {
            is HomeAction.InitViewModel -> {
                viewModelScope.launch {
                    try {
                        val movies = discoverMovieUseCase.execute()

                    } catch (e: Exception) {

                    }
                }
                HomeActionResult.LoadMovies
            }
        }
    }

    override fun onResult(result: HomeActionResult): HomeViewState {
        return when (result) {
            is HomeActionResult.LoadMovies -> HomeViewState.Loading(false)
        }
    }
}

sealed class HomeAction : Action {
    object InitViewModel : HomeAction()
}

sealed class HomeViewState : ViewState {
    data class Loading(val isLoading: Boolean) : HomeViewState()
    data class Error(val errorMessage: String) : HomeViewState()
    data class ShowMovie(val movies : List<Movie>) : HomeViewState()
}

sealed class HomeActionResult : ActionResult {
    object LoadMovies : HomeActionResult()
}