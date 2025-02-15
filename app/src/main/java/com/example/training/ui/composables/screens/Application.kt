package com.example.training.ui.composables.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Application() {
    val navController = rememberNavController()
    val navigate = { destination: String ->
        navController.navigate(destination)
    }
    val navigateUp = { navController.navigateUp() }
    NavHost(
        navController = navController,
        startDestination = "HomeScreen"
    ) {
        composable(route = "HomeScreen") {
            HomeScreen(navigate)
        }
        composable(
            route = "VideoDetailsScreen/{videoId}",
            arguments = listOf(
                navArgument("videoId") {
                    type = NavType.IntType
                }
            )
        ) {
            val videoId = it.arguments?.getInt("videoId")
            VideoDetailsScreen(navigate, navigateUp, videoId)
        }
        composable(route="SavedVideosScreen") {
            SavedVideosScreen(navigateUp)
        }
    }
}