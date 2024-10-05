package com.amit.mealsapp.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ProgressDialog(show: Boolean) {
    if (show) {
        Dialog(onDismissRequest = { /* Do nothing to prevent dismissing */ }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent) // Use a transparent background
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp) // Adjust size as needed
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(8.dp)
                        ) // Rounded corners
                        .align(Alignment.Center) // Center alignment
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}
