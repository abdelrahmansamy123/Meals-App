package com.amit.mealsapp.ui.screens.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.amit.mealsapp.Screen
import com.google.gson.Gson

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
    navController: NavController? = null,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val meals by viewModel.meals.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 30.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
        ) {
            items(meals.categories) { item ->
                MealItemScreen(
                    title = item.strCategory ?: "",
                    imageUrl = item.strCategoryThumb ?: ""
                ) {
                    val gson = Gson()
                    val categoryDataJson = gson.toJson(item)
                    val encodedCategoryDataJson =
                        java.net.URLEncoder.encode(categoryDataJson, "UTF-8")
                    navController?.navigate("${Screen.MealDetailsScreen.route}/${encodedCategoryDataJson}")
                }
            }
        }
    }
}