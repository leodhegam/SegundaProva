package com.tads.segundaprova

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.tads.segundaprova.database.AppDatabase
import com.tads.segundaprova.database.model.Usuario

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var DB_NAME = "usuario-database.sqlite";

    var list: LiveData<List<Usuario>>

    init {
        val db:AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                    AppDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .build()
        }

        list = db.usuarioDao().listAll()
    }
}

