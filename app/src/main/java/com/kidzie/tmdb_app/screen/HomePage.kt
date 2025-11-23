package com.kidzie.tmdb_app.screen

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kidzie.tmdb_app.R
import com.kidzie.tmdb_app.ui.theme.AppTheme
import com.kidzie.tmdb_app.viewmodel.HomeAction
import com.kidzie.tmdb_app.viewmodel.HomeViewModel


data class BottomNavigationItem(
    val title: String,
    @param:DrawableRes val icon: Int,
)

@Composable
fun HomeScreen(accountName: String = "") {
    val homeViewModel: HomeViewModel = hiltViewModel()
    homeViewModel.onAction(HomeAction.InitViewModel)
    Scaffold(
        topBar = {
            HomeTopBar(accountName = accountName)
        },
        bottomBar = {
            BottomNavBar()
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {}
    }
}

@Composable
fun HomeTopBar(accountName: String = "") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (accountName.isNotEmpty()) {
            Text(text = "Welcome, $accountName", fontSize = 20.sp)
        } else {
            Text(text = "For You", fontSize = 20.sp)
        }
        ImageTopBar(modifier = Modifier)
    }
}

@Composable
fun ImageTopBar(modifier: Modifier) {
    Row(
        modifier = modifier.wrapContentWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(contentDescription = "cast", painter = painterResource(R.drawable.ic_cast))
        Image(contentDescription = "download", painter = painterResource(R.drawable.ic_download))
        Image(contentDescription = "search", painter = painterResource(R.drawable.ic_search))
    }
}

@Composable
fun  BottomNavBar() {
    var selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val bottomNavigationItems = listOf(
        BottomNavigationItem(
            title = "Home",
            icon = R.drawable.ic_home,
        ),
        BottomNavigationItem(
            title = "News and Hot",
            icon = R.drawable.ic_news_hot,
        ),
        BottomNavigationItem(
            title = "Account",
            icon = R.drawable.ic_account,
        ),

        )

    NavigationBar(
        modifier = Modifier.windowInsetsPadding(NavigationBarDefaults.windowInsets)
    ) {
        bottomNavigationItems.forEachIndexed { index, item ->
            NavigationBarItem(selected = selectedIndex == index, onClick = {
                selectedIndex = index
            }, label = {
                Text(
                    text = item.title,
                    color = if (selectedIndex == index) Color.White else Color.Gray
                )
            }, icon = {
                Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.title,
                    tint = if (selectedIndex == index) Color.White else Color.Gray
                )
            })
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun HomeScreenPreview() {
    AppTheme() {
        Scaffold() { innerPadding ->
            HomeScreen()
        }

    }

}
