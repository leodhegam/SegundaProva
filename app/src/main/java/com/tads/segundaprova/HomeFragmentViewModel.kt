package com.tads.segundaprova

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.tads.segundaprova.database.AppDataBase
import com.tads.segundaprova.model.Usuario

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {


    var list: LiveData<List<Usuario>>

    init {
        val db:AppDataBase by lazy {
            Room.databaseBuilder(application.applicationContext,
                    AppDataBase::class.java, "usuario-database")
                    .allowMainThreadQueries()
                    .build()
        }

        list = db.usuarioDao().listAll()

    }
    @SuppressLint("StaticFieldLeak")
    inner class taskAsync(var db: AppDataBase): AsyncTask<Int, Int, LiveData<List<Usuario>>>() {
        override fun doInBackground(vararg params: Int?): LiveData<List<Usuario>> {
            return db.usuarioDao().listAll()
        }
    }
}

