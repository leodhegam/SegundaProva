package com.tads.segundaprova

import android.content.Context
import android.os.AsyncTask
import com.tads.segundaprova.dao.UsuarioDAO
import com.tads.segundaprova.model.Usuario

class UsuarioRepository(context: Context) {

//    fun insert(usuarioDAO: String){
//        InsertUsuarioAsyncTask(usuarioDAO)
//    }
    fun update(usuarioDAO: UsuarioDAO){
        UpdateUsuarioAsyncTask(usuarioDAO)
    }
    fun delete(usuarioDAO: UsuarioDAO){
        DeleteUsuarioAsyncTask(usuarioDAO)
    }
}
//class InsertUsuarioAsyncTask(var usuarioDAO: String): AsyncTask<Usuario,Unit,Unit>() {
//    override fun doInBackground(vararg params: Usuario?) {
//        return usuarioDAO.insert(params.get(0)!!)
//    }
//}
class UpdateUsuarioAsyncTask(var usuarioDAO: UsuarioDAO): AsyncTask<Usuario, Unit, Unit>(){
    override fun doInBackground(vararg params: Usuario?) {
        return usuarioDAO.update(params.get(0)!!)
    }
}

class DeleteUsuarioAsyncTask(var usuarioDAO: UsuarioDAO): AsyncTask<Usuario,Unit,Unit>(){
    override fun doInBackground(vararg params: Usuario?) {
        return usuarioDAO.delete(params.get(0)!!)
    }
}