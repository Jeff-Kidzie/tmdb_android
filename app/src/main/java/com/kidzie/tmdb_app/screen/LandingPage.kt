package com.kidzie.tmdb_app.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kidzie.tmdb_app.R
import com.kidzie.tmdb_app.data.Account

@Suppress("UNUSED_PARAMETER")
@Composable
fun LandingScreen(modifier: Modifier = Modifier, navController: NavController) {
    val onClickCard = {
        navController.navigate(ScreenRoute.Home)
    }
    val listAccount = listOf(
        Account(
            id = 1,
            idImage = R.drawable.profile_1,
            name = "John Doe",
        ), Account(
            id = 2, idImage = R.drawable.profile_2, name = "Jane Smith"
        ), Account(
            id = 3, idImage = R.drawable.profile_3, name = "Alice Johnson"
        )
    )
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.Center)
        ) {
            // to show add profile card at the end of the list
            items(listAccount.size + 1) { index ->

                if (index == listAccount.size) {
                    AddProfileCard()
                    return@items
                }
                val account = listAccount[index]
                CardProfile(
                    idImage = account.idImage, accountName = account.name, onClick = onClickCard
                )
            }
        }
    }
}

@Composable
fun CardProfile(
    modifier: Modifier = Modifier,
    @DrawableRes idImage: Int,
    accountName: String,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .wrapContentSize()
            .padding(vertical = 8.dp)
            .clickable {
                onClick()
            }, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = idImage),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = accountName, color = Color(Color.White.value))
    }
}

@Composable
fun AddProfileCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .wrapContentSize()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(1.dp, Color.White, RoundedCornerShape(16.dp)),
        ) {
            Text(
                text = "+",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 24.sp
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Add Profile", color = Color(Color.White.value))
    }
}

@Preview
@Composable
fun LandingScreenPreview() {
    val mockNavController = rememberNavController()
    LandingScreen(navController = mockNavController)
}

@Preview
@Composable
fun CardProfilePreview() {
    CardProfile(idImage = R.drawable.profile_1, accountName = "John Doe")
}

@Preview
@Composable
fun AddProfileCardPreview() {
    AddProfileCard()
}

