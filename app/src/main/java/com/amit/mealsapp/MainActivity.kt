package com.amit.mealsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsAppComposable() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Meals App") }
            )
        }
    ) {
        // Apply padding to NavHost
        NavHost(
            navController = navController,
            startDestination = Screen.HomeScreen.route,
            modifier = Modifier
                .fillMaxSize() // Ensures NavHost takes up available space
                .padding(it) // Use paddingValues to respect Scaffold's padding
        ) {
            composable(Screen.HomeScreen.route) { HomeScreen(navController) }
            composable(
                "${Screen.MealDetailsScreen.route}/{category}",
                arguments = listOf(navArgument("category") { type = NavType.StringType })
            ) {
                MealDetailsScreen()
            }
        }
    }
}