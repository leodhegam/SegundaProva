package com.tads.segundaprova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tads.segundaprova.model.Usuario

class UsuarioAdapter: RecyclerView.Adapter<UsuarioViewHolder>() {

    var usuarios:List<Usuario> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.home_inflater, parent, false)
        return UsuarioViewHolder(v)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val select = usuarios[position]
        holder.nameApp.text = select.nome
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }

}
class UsuarioViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val nameApp = v.findViewById<TextView>(R.id.nameApp)
}