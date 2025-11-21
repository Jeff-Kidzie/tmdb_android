package com.kidzie.tmdb_app.core

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<A : Action, VA : ActionResult,VS : ViewState> : ViewModel() {

    abstract fun onAction(action: A) : VA
    abstract fun onResult(result: VA) : VS
}
