package com.amit.mealsapp.ui.screens.screendetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun MealDetailsScreen(viewModel: MealDetailsViewModel = hiltViewModel()) {

    val category by viewModel.category.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically)
    ) {
        AsyncImage(
            model = category.strCategoryThumb,
            contentDescription = "Meal Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape)
        )

        Text(
            category.strCategory ?: "",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            category.strCategoryDescription ?: "",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}