package com.kidzie.tmdb_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kidzie.tmdb_app.screen.HomeScreen
import com.kidzie.tmdb_app.screen.LandingScreen
import com.kidzie.tmdb_app.screen.ScreenRoute
import com.kidzie.tmdb_app.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme() {
                Scaffold { innerPadding ->
                    MainApp(innerPadding)
                }
            }
        }
    }
}

@Composable
fun MainApp(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.Landing,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable<ScreenRoute.Landing> {
            LandingScreen(navController = navController)
        }

        composable<ScreenRoute.Home> {
            HomeScreen()
        }

    }

}