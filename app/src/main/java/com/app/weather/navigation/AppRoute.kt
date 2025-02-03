package com.app.weather.navigation

sealed class AppRoute(val route: String) {

    data object HomeRoute : AppRoute(route = "home_screen")

    data object HistoryRoute : AppRoute(route = "history_screen")

}



