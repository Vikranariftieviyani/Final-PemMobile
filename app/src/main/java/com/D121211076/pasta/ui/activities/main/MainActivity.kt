package com.D121211076.pasta.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211076.pasta.Data.models.Article
import com.D121211076.pasta.ui.activities.detail.DetailActivity
import com.D121211076.pasta.ui.theme.D121211076pastaTheme
import com.google.firebase.inappmessaging.model.Button

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D121211076pastaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "List Pasta") },
                            )
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = {}) {
                                Icon(Icons.Default.Add, contentDescription = "Add")
                            }
                        }
                    ) {
                        Column(modifier = Modifier.padding(it)) {
                            val mainViewModel: MainViewModel =
                                viewModel(factory = MainViewModel.Factory)
                            ListPastaScreen(mainViewModel.mainUiState)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ListPastaScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when (mainUiState) {
            is MainUiState.Success -> ListPasta(mainUiState.pasta)
            is MainUiState.Error -> ErrorText()
            is MainUiState.Loading -> LoadingBar()
        }
    }

    @Composable
    private fun ErrorText() {
        Text(text = "ERROR")
    }

    @Composable
    fun LoadingBar() {
        Text(text = "SEDANG LOADING")
    }

    @Composable
    fun ListPasta(article: Article?) {
        article?.let {
            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("meals", it.strMealThumb)
                startActivity(intent)
            }) {
                Text("Chilli prawn linguine")
            }

            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("meals", it.strMealThumb)
                startActivity(intent)
            }) {
                Text("Fettucine Alfredo")
            }

            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("meals", it.strMealThumb)
                startActivity(intent)
            }) {
                Text("Fettucine alfredo")
            }

            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("meals", it.strMealThumb)
                startActivity(intent)
            }) {
                Text("Grilled Mac and Cheese Sandwich")
            }

            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("meals", it.strMealThumb)
                startActivity(intent)
            }) {
                Text("Lasagna Sandwiches")
            }

            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("meals", it.strMealThumb)
                startActivity(intent)
            }) {
                Text("Lasagne")
            }

            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("meals", it.strMealThumb)
                startActivity(intent)
            }) {
                Text("Pilchard Puttanesca")
            }

            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("meals", it.strMealThumb)
                startActivity(intent)
            }) {
                Text("Spaghetti alla Carbonara")
            }

            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("meals", it.strMealThumb)
                startActivity(intent)
            }) {
                Text("Venetian Duck Ragu")
            }
        }

    }
}