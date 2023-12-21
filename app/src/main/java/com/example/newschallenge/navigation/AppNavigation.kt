package com.example.newschallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.domain.News
import com.example.newschallenge.ui.screen.MainScreen
import com.example.newschallenge.ui.screen.NewsDetailScreen
import com.example.newschallenge.ui.screen.UserLocationScreen
import com.example.newschallenge.ui.screen.UserScreen
import com.google.gson.Gson

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreen.MainScreen.route) {
        composable(route = AppScreen.MainScreen.route) {
            MainScreen(onClickItem = { newsClicked ->
                navController.navigate("${AppScreen.NewsDetailScreen.route}/$newsClicked")
            }, onLocationCLick = {
                navController.navigate(AppScreen.UserLocation.route)
            })
        }

        composable(
            route = "${AppScreen.NewsDetailScreen.route}/{newsClicked}",
            arguments = listOf(navArgument("newsClicked") { type = NavType.StringType }),

        ) { navBackStackEntry ->
            val newsArg = navBackStackEntry.arguments?.getString("newsClicked")
            val news = Gson().fromJson(newsArg, News::class.java)
            NewsDetailScreen(news)
        }

        composable(route = AppScreen.UserScreen.route) {
            UserScreen(onLocationCLick = {
                navController.navigate(AppScreen.UserLocation.route)
            })
        }

        composable(route = AppScreen.UserLocation.route) {
            UserLocationScreen()
        }
    }
}
