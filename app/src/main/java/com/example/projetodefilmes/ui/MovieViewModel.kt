package com.example.projetodefilmes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.projetodefilmes.data.Movie
import com.example.projetodefilmes.data.MovieDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class MovieViewModel(private val dao: MovieDao) : ViewModel() {


    val listaDeFilmes: Flow<List<Movie>> = dao.getTodosFilmes()


    fun salvarOuAtualizarFilme(movie: Movie) {
        viewModelScope.launch {

            dao.salvarFilme(movie)
        }
    }

    fun excluirFilme(movie: Movie) {
        viewModelScope.launch {
            dao.excluirFilme(movie)
        }
    }
}


class MovieViewModelFactory(private val dao: MovieDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
