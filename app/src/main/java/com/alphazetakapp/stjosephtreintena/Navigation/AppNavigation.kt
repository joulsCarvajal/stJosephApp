package com.alphazetakapp.stjosephtreintena.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alphazetakapp.stjosephtreintena.*
import com.alphazetakapp.stjosephtreintena.ReadMeditationScreen.MeditationScreenViewModel

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Routes.SplashScreen.routes
    ) {
        composable(Routes.SplashScreen.routes) {
            SplashScreen(navigationController)
        }
        composable(Routes.MainScreen.routes) {
            val context = LocalContext.current
            MainScreen(navigationController, context = context)
        }
        composable(Routes.PrepMeditation.routes) {
            PrepMeditation(navigationController)
        }
        composable(Routes.DaysScreen.routes) {
            DaysScreen(navigationController)
        }
        composable(
            Routes.MeditationScreen.routes,
            arguments = listOf(
                navArgument("day") { defaultValue = "Day X" },
                navArgument("dayNum") { defaultValue = 0 },
                navArgument("dailyRecord") { defaultValue = 0 })
        ) { backStackEntry ->
            val day = backStackEntry.arguments?.getString("day") ?: "Day X"
            val dayNum = backStackEntry.arguments?.getInt("dayNum") ?: 0
            val dailyRecord = backStackEntry.arguments?.getInt("dailyRecord") ?: 0
            val context = LocalContext.current
            MeditationScreen(
                dayNum = dayNum,
                day = day,
                dailyRecord = dailyRecord,
                context = context
            )
        }
    }
}