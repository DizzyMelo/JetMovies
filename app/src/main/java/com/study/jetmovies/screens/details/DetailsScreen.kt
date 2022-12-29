package com.study.jetmovies.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.study.jetmovies.model.getMovie

@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    val movie by remember {
        mutableStateOf(getMovie(movieId))
    }

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.LightGray,
            elevation = 5.dp
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
               IconButton(onClick = { navController.popBackStack() }) {
                   Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go back")
               }
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Movies")
            }
        }
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = movie!!.actors, style = MaterialTheme.typography.h4)
            }
        }
    }
}