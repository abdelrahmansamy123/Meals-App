package com.amit.mealsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.amit.mealsapp.ui.screens.homescreen.HomeScreen
import com.amit.mealsapp.ui.screens.screendetails.MealDetailsScreen
import com.amit.mealsapp.ui.theme.MealsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealsAppTheme {
                MealsAppComposable()
            }
        }
    }
}

@Composable
fun MealsAppComposable() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homeScreen") {
        composable(Screen.HomeScreen.route) { HomeScreen(navController) }
        composable(
            "${Screen.MealDetailsScreen.route}/{mealName}",
            arguments = listOf(navArgument("mealName") { type = NavType.StringType })
        ) { MealDetailsScreen() }
    }
}

