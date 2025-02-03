package com.app.weather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.weather.feature.history.HistoryScreen
import com.app.weather.feature.home.HomeScreen


@Composable
fun NavigationHostApp(navHostController: NavHostController = rememberNavController()) {
    NavHost(navController = navHostController, startDestination = AppRoute.HomeRoute.route) {
        composable(route = AppRoute.HomeRoute.route) {
            HomeScreen()
        }

        composable(route = AppRoute.HistoryRoute.route) {
            HistoryScreen()
        }
    }


}
