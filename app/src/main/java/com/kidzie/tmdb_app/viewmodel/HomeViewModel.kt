package com.kidzie.tmdb_app.viewmodel

import androidx.lifecycle.viewModelScope
import com.kidzie.tmdb_app.core.Action
import com.kidzie.tmdb_app.core.ActionResult
import com.kidzie.tmdb_app.core.BaseViewModel
import com.kidzie.tmdb_app.core.Result
import com.kidzie.tmdb_app.core.ViewState
import com.kidzie.tmdb_app.data.model.Movie
import com.kidzie.tmdb_app.domain.usecase.DiscoverMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val discoverMovieUseCase: DiscoverMovieUseCase) :
    BaseViewModel<HomeAction, HomeActionResult, HomeViewState>(HomeViewState()) {

    val homeViewState = MutableStateFlow(HomeViewState())
    private var _homeViewState: StateFlow<HomeViewState> = homeViewState.asStateFlow()

    override fun reduce(
        actionResult: HomeActionResult,
        currentState: HomeViewState
    ): HomeViewState {
        return HomeReducer.reduce(actionResult, _homeViewState.value)
    }

    override fun handleAction(action: HomeAction): HomeActionResult {
        when (action) {
            HomeAction.InitViewModel -> {
                viewModelScope.launch {
                    when(val moviesResult = discoverMovieUseCase()) {
                        is Result.Success -> {
                            updateState { currentState ->
                                currentState.copy(movies = moviesResult.data , isLoading = false)
                            }
                        }
                        is Result.Error ->  {
                            updateState { currentState ->
                                currentState.copy(error = moviesResult.errorMessage, isLoading = false)
                            }
                        }
                        Result.Loading -> {
                            updateState { currentState ->
                                currentState.copy(isLoading = true)
                            }
                        }
                    }

                }
                return HomeActionResult.ShowLoading(false)
            }

        }
    }
}

sealed class HomeAction : Action {
    object InitViewModel : HomeAction()
}

data class HomeViewState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val mainMovie: Movie = Movie(),
    val error: String = "",
) : ViewState

sealed class HomeActionResult : ActionResult {
    data class ShowLoading(val isLoading: Boolean) : HomeActionResult()
    data class LoadMovies(val movies: List<Movie>) : HomeActionResult()
}

object HomeReducer {
    fun reduce(actionResult: HomeActionResult, viewState: HomeViewState): HomeViewState {
        return when (actionResult) {
            is HomeActionResult.LoadMovies -> {
                viewState.copy(movies = actionResult.movies)
            }

            is HomeActionResult.ShowLoading -> {
                viewState.copy(isLoading = actionResult.isLoading)
            }
        }
    }
}