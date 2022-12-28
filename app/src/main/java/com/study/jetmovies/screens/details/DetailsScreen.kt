package com.study.jetmovies.screens.details

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
            Text(text = "Movies")
        }
    }) {
        Text(text = "Details")
    }
}