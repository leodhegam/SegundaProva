package com.tads.segundaprova.database

import android.content.Context
import androidx.room.Room

class Bd(context: Context) {

    private val db : AppDataBase by lazy {
        Room.databaseBuilder(context,AppDataBase::class.java,"usuario-database").allowMainThreadQueries().build()
    }

    fun instance():AppDataBase{
        return db;
    }
}