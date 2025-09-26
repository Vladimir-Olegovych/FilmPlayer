package com.gigcreator.filmplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gigcreator.filmplayer.feature.home.HomeScreen
import com.gigcreator.filmplayer.core.navigation.HomeDestination
import com.gigcreator.filmplayer.feature.shared.theme.FilmPlayerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FilmPlayerTheme {
                NavigationHost()
            }
        }
    }
}

@Composable
fun NavigationHost(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeDestination) {
        composable<HomeDestination> {
            HomeScreen()
        }
    }

}