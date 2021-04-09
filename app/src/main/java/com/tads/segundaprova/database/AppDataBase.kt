package com.tads.segundaprova.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tads.segundaprova.dao.UsuarioDAO
import com.tads.segundaprova.model.Usuario


@Database(entities = [Usuario::class], version = 1 )
abstract class AppDataBase: RoomDatabase(){
    abstract fun usuarioDao(): UsuarioDAO

}