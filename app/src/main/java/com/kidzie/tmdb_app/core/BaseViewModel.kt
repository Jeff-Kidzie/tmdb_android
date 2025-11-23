package com.kidzie.tmdb_app.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<A : Action, AR : ActionResult,VS : ViewState>(initialState : VS) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state : StateFlow<VS> = _state


    protected abstract fun reduce(actionResult: AR, currentState : VS) : VS
    protected abstract fun handleAction(action: A) : AR

    fun onAction(action : A) {
        CoroutineScope(Dispatchers.Main).launch {
            _state.update { currentState ->
                reduce(actionResult = handleAction(action), currentState)
            }
        }
    }

    protected fun updateState(transform: (VS) -> VS) {
        _state.update(transform)
    }
}
