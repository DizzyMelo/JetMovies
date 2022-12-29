package com.study.jetmovies.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.study.jetmovies.model.Movie
import com.study.jetmovies.model.getMovie
import com.study.jetmovies.widgets.HorizontalScrollableImageView
import com.study.jetmovies.widgets.MovieRow

@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    val movie = getMovie(movieId)

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
                verticalArrangement = Arrangement.Top
            ) {
                MovieRow(movie = movie!!, isExpanded = true)
                Spacer(modifier = Modifier.height(8.dp))
                Divider(modifier = Modifier.padding(4.dp))
                Text(text = "Movie Images")
                HorizontalScrollableImageView(movie)
            }
        }
    }
}