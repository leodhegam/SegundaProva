package com.tads.segundaprova.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tads.segundaprova.model.Usuario

@Dao
interface UsuarioDAO {

//Você deve implementar métodos para: cadastrar, editar, listar todos, listar por ID, excluir

    @Insert //cadastrar
    fun insert(usuario: Usuario)

    @Update //editar
    fun update(usuario: Usuario)

    @Query("SELECT * FROM tabela_usuario") //listar todos
    fun listAll(): LiveData<List<Usuario>>

    @Query("SELECT * FROM tabela_usuario WHERE id = :id") //listar por ID
    fun findById(id: Long): Usuario

    @Delete //excluir
    fun delete(usuario: Usuario)
}