package com.example.projetodefilmes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.projetodefilmes.ui.MovieListScreen
import com.example.projetodefilmes.ui.MovieViewModel
import com.example.projetodefilmes.ui.MovieViewModelFactory
import com.example.projetodefilmes.ui.theme.ProjetoDeFilmesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val application = application as MyFilmesApplication


        val viewModel: MovieViewModel by viewModels {
            MovieViewModelFactory(application.database.movieDao())
        }

        setContent {
            ProjetoDeFilmesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MovieListScreen(viewModel = viewModel)
                }
            }
        }
    }
}
