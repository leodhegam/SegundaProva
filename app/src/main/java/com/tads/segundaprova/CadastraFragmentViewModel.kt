package com.tads.segundaprova

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.tads.segundaprova.dao.UsuarioDAO
import com.tads.segundaprova.model.Usuario
import kotlinx.coroutines.launch
import java.lang.Exception

class CadastraFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var usuarios : Usuario

    var nome=""
    var email=""
    var cidade=""
    var anoNascimento=0
    var cpf=0
    var profissao=""

  init{
      usuarios = Usuario(0,nome,email,cidade,anoNascimento,cpf,profissao)
  }

}



