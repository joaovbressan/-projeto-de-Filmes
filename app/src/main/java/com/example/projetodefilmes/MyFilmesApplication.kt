package com.example.projetodefilmes

import android.app.Application
import androidx.room.Room
import com.example.projetodefilmes.data.AppDatabase


class MyFilmesApplication : Application() {


    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_filmes_database"
        ).build()
    }
}
