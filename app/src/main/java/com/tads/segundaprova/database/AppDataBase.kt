package com.tads.segundaprova.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tads.segundaprova.database.dao.UsuarioDAO
import com.tads.segundaprova.database.model.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDAO
}
