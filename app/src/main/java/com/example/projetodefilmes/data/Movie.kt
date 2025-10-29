package com.example.projetodefilmes.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "filmes_salvos")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val ano: String,
    val sinopse: String
)
