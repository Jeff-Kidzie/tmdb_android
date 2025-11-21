package com.kidzie.tmdb_app.data.model

import androidx.annotation.DrawableRes

data class Account(
    val id: Int,
    val name: String,
//    val avatarPath: String,
    @param:DrawableRes val idImage: Int,
)