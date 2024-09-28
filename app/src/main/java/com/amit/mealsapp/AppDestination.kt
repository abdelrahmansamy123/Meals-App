package com.amit.mealsapp

sealed class Screen(val route: String){
    object HomeScreen: Screen("homeScreen")
    object MealDetailsScreen: Screen("mealDetailsScreen")
}