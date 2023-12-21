package com.example.newschallenge.navigation

import com.example.newschallenge.navigation.AppDestination.MAIN_SCREEN_ROUTE
import com.example.newschallenge.navigation.AppDestination.NEWS_DETAIL_SCREEN_ROUTE
import com.example.newschallenge.navigation.AppDestination.USER_LOCATION_SCREEN_ROUTE
import com.example.newschallenge.navigation.AppDestination.USER_SCREEN_ROUTE

object AppDestination {

    const val MAIN_SCREEN_ROUTE = "MAIN_SCREEN_ROUTE"
    const val NEWS_DETAIL_SCREEN_ROUTE = "NEWS_DETAIL_SCREEN_ROUTE"
    const val USER_SCREEN_ROUTE = "USER_SCREEN_ROUTE"
    const val USER_LOCATION_SCREEN_ROUTE = "USER_LOCATION_SCREEN_ROUTE"

}

sealed class AppScreen(val route: String) {
    object MainScreen : AppScreen(MAIN_SCREEN_ROUTE)
    object NewsDetailScreen : AppScreen(NEWS_DETAIL_SCREEN_ROUTE)
    object UserScreen : AppScreen(USER_SCREEN_ROUTE)
    object UserLocation : AppScreen(USER_LOCATION_SCREEN_ROUTE)
}
