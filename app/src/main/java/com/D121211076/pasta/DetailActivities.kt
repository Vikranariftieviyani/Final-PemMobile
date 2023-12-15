package com.D121211076.pasta

import com.D121211076.pasta.Data.models.Article
import com.D121211076.pasta.ui.theme.D121211076pastaTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest


class DetailActivities : ComponentActivity() {

    private var selectedArticle: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedArticle = intent.getParcelableExtra("Pasta")
        setContent {
            D121211076pastaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodDetailScreen()
                }
            }
        }
    }

    @Composable
    fun FoodDetailScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Character Image
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(selectedArticle?.strMealThumb)
                    .crossfade(true)
                    .build(),
                contentDescription = selectedArticle?.strMeal,
                modifier = Modifier
                    .width(400.dp)
                    .height(400.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = selectedArticle?.strMeal ?: "Unknown", style = MaterialTheme.typography.displayMedium)

        }
    }
}