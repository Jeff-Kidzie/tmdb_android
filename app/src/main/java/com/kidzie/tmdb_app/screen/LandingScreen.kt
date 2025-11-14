package com.kidzie.tmdb_app.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kidzie.tmdb_app.R
import com.kidzie.tmdb_app.data.Account

class LandingScreen {

    val accountList = listOf<Account>(
        Account(1, "John Doe", "johndoe", "/path/to/avatar1.jpg"),
        Account(2, "Jane Smith", "janesmith", "/path/to/avatar2.jpg"),
        Account(3, "Alice Johnson", "alicej", "/path/to/avatar3.jpg")
    )

    @Composable
    fun LandingScreenPage() {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(accountList, key = { it.id }) { account ->
                // For preview purposes, using a placeholder image resource
                CardProfile(R.drawable.profile_1, account.name)
            }
        }
    }
}

@Composable
fun CardProfile(@DrawableRes imageRes: Int, name: String) {
    Column() {
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = imageRes),
            contentDescription = "Profile Image"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(name,
            textAlign = TextAlign.Center,
            color = Color(Color.White.value))
    }
}

@Preview
@Composable
fun LandingScreenPagePreview() {
    val landingScreen = LandingScreen()
    landingScreen.LandingScreenPage()
}

@Preview
@Composable
fun CardProfilePreview() {
    CardProfile(R.drawable.profile_1, "John Doe")
}