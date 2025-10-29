package com.example.projetodefilmes.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.projetodefilmes.data.Movie

/**
 * Fase 4: A UI (Tela) com Jetpack Compose
 * Esta tela exibe o formulário e a lista.
 */
@Composable
fun MovieListScreen(viewModel: MovieViewModel) {
    // Coleta o Flow do ViewModel. A tela será "recomposta"
    // automaticamente sempre que a listaDeFilmes mudar.
    val filmes by viewModel.listaDeFilmes.collectAsState(initial = emptyList())

    // Estados para os campos de texto do formulário
    var titulo by remember { mutableStateOf("") }
    var ano by remember { mutableStateOf("") }
    var sinopse by remember { mutableStateOf("") }

    // Guarda o filme que está sendo editado (se houver)
    var filmeEmEdicao by remember { mutableStateOf<Movie?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = if (filmeEmEdicao == null) "Adicionar Novo Filme" else "Editando: ${filmeEmEdicao!!.titulo}",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Formulário para salvar/atualizar
        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = ano,
            onValueChange = { ano = it },
            label = { Text("Ano") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = sinopse,
            onValueChange = { sinopse = it },
            label = { Text("Sinopse") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // (salvarFilme / atualizarFilme)
            Button(onClick = {
                val filme = filmeEmEdicao?.copy( // Se estiver editando, copia o ID
                    titulo = titulo,
                    ano = ano,
                    sinopse = sinopse
                ) ?: Movie( // Se for novo, cria um novo
                    titulo = titulo,
                    ano = ano,
                    sinopse = sinopse
                )

                viewModel.salvarOuAtualizarFilme(filme)

                // Limpa os campos e reseta a edição
                titulo = ""
                ano = ""
                sinopse = ""
                filmeEmEdicao = null
            }) {
                Text(if (filmeEmEdicao == null) "Salvar" else "Atualizar")
            }

            // Botão para limpar/cancelar edição
            if (filmeEmEdicao != null) {
                Button(
                    onClick = {
                        titulo = ""
                        ano = ""
                        sinopse = ""
                        filmeEmEdicao = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                ) {
                    Text("Cancelar Edição")
                }
            }
        }


        Spacer(modifier = Modifier.height(24.dp))
        Divider()
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Filmes Salvos", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        // (listaFilmes)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(filmes) { filme ->
                MovieItem(
                    movie = filme,
                    onEdit = {
                        // (gatilho atualizarFilme)
                        // Preenche os campos para edição
                        titulo = filme.titulo
                        ano = filme.ano
                        sinopse = filme.sinopse
                        filmeEmEdicao = filme
                    },
                    onDelete = {
                        // (excluirFilme)
                        viewModel.excluirFilme(filme)
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onEdit: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEdit() } // Clicar no card ativa a edição
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = movie.titulo, style = MaterialTheme.typography.titleMedium)
                Text(text = "Ano: ${movie.ano}", style = MaterialTheme.typography.bodySmall)
                Text(text = movie.sinopse, style = MaterialTheme.typography.bodySmall, maxLines = 2)
            }
            IconButton(
                onClick = onDelete,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                // Você pode usar um ícone aqui
                Text("X", color = Color.Red)
            }
        }
    }
}
