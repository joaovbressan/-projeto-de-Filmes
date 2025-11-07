package com.example.projetodefilmes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Fase 2: O DAO (Data Access Object)
 * Define as operações de banco de dados (CRUD).
 */
@Dao
interface MovieDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun salvarFilme(movie: Movie)


    @Update
    suspend fun atualizarFilme(movie: Movie)


    @Delete
    suspend fun excluirFilme(movie: Movie)


    @Query("SELECT * FROM filmes_salvos ORDER BY titulo ASC")
    fun getTodosFilmes(): Flow<List<Movie>>
}
