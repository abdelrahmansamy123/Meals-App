package com.amit.mealsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.amit.mealsapp.ui.screens.homescreen.HomeScreen
import com.amit.mealsapp.ui.screens.screendetails.MealDetailsScreen
import com.amit.mealsapp.ui.theme.MealsAppTheme
import com.amit.mealsapp.ui.view.ProgressDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

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

    var isLoading by remember { mutableStateOf(true) } // Loading state

    // Simulate loading data
    LaunchedEffect(Unit) {
        // Simulate a loading delay (replace this with your data fetching logic)
        delay(2000)
        isLoading = false // Set loading to false after the operation
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.ic_logo), // Replace with your logo resource
            contentDescription = "Background Image",
            contentScale = ContentScale.Fit, // Change this based on your needs
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
        )

        // Main Scaffold with top bar and navigation
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(text = "Meals App") })
            }
        ) { paddingValues ->
            // Apply padding to NavHost
            NavHost(
                navController = navController,
                startDestination = Screen.HomeScreen.route,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues) // Use paddingValues to respect Scaffold's padding
            ) {
                composable(Screen.HomeScreen.route) { HomeScreen(navController) }
                composable(
                    "${Screen.MealDetailsScreen.route}/{category}",
                    arguments = listOf(navArgument("category") { type = NavType.StringType })
                ) {
                    MealDetailsScreen() // Pass category to MealDetailsScreen
                }
            }
        }
        // Show progress dialog while loading
        ProgressDialog(show = isLoading)
    }
}

