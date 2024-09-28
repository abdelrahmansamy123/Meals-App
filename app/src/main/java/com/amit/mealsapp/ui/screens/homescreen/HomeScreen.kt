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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
    navController: NavController? = null, viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val meals by viewModel.meals.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 30.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 5.dp)
        ) {
            items(meals.categories) { item ->
                MealItemScreen(
                    title = item.strCategory ?: "", imageUrl = item.strCategoryThumb ?: ""
                ) { navController?.navigate("${Screen.MealDetailsScreen.route}/${item.strCategory}") }
            }
        }
    }

}


