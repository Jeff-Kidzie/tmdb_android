package com.kidzie.tmdb_app.screen

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenRoute {
    @Serializable
    data object Landing : ScreenRoute()

    @Serializable
    data object Home : ScreenRoute()
}