package com.D121211076.pasta.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211076.pasta.Data.models.Article
import com.D121211076.pasta.ui.theme.D121211076pastaTheme

class DetailActivity : ComponentActivity() {

    private var selectedPasta: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedPasta = intent.getParcelableExtra("meals")
        setContent {
            D121211076pastaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }

    @Composable
    private fun DetailScreen() {
        LazyColumn {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(selectedPasta?.strMealThumb)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Ini gambar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = selectedPasta?.strMeal.toString())
            }
        }
    }

}