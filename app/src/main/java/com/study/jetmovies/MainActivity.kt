package com.study.jetmovies

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.jetmovies.ui.theme.JetMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetMoviesTheme {
        Scaffold(topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
                Text(text = "Movies")
            }
        }) {
            content()
        }
    }
}

@Composable
fun MainContent(movieList: List<String> = listOf("Indiana Jones", "Top Gun", "Avatar", "Power Rangers", "Run", "Get out")) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn(content = {
            items(items = movieList) { movie ->
                MovieRow(movie = movie) {
                    Log.d("MV", "MainContent: $it")
                }
            }
        })
    }
}

@Composable
fun MovieRow(movie: String, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onClick.invoke(movie) },
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = 5.dp

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 5.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Icon")
            }
            Text(text = movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}