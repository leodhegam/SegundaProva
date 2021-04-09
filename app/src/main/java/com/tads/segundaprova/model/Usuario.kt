package com.tads.segundaprova.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="tabela_usuario")
data class Usuario (
        @PrimaryKey(autoGenerate = true)
        var id:Long = 0,
    var nome:String="",
    var email:String="",
    var cidade:String="",
    var anoNascimento:Int,
    var cpf:Int,
    var profissao:String="",
)
