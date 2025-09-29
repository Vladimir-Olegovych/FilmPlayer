package com.gigcreator.filmplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gigcreator.filmplayer.core.navigation.FilmDestination
import com.gigcreator.filmplayer.core.navigation.HomeDestination
import com.gigcreator.filmplayer.feature.film.FilmScreen
import com.gigcreator.filmplayer.feature.home.HomeScreen
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
            HomeScreen(navigateFilm = { film -> navController.navigate(FilmDestination(film)) })
        }
        composable<FilmDestination> { backStackEntry ->
            val destination = backStackEntry.toRoute<FilmDestination>()
            FilmScreen(film = destination.film, navigateBack = { navController.popBackStack() })
        }
    }

}