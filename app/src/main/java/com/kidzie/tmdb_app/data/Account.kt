package com.kidzie.tmdb_app.data

import androidx.annotation.DrawableRes

data class Account(
    val id: Int,
    val name: String,
//    val avatarPath: String,
    @DrawableRes val idImage: Int,
)