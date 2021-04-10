package com.tads.segundaprova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.tads.segundaprova.database.Bd
import com.tads.segundaprova.databinding.FragmentAlteraBinding
import com.tads.segundaprova.databinding.FragmentDetalhesBinding
import com.tads.segundaprova.model.Usuario
import kotlinx.android.synthetic.main.fragment_detalhes.*

class DetalhesFragment : Fragment() {

    lateinit var usuario: Usuario
    lateinit var binding: FragmentDetalhesBinding
    lateinit var bd: Bd

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detalhes,container,false)
        bd = Bd(inflater.context)

        val args: AlteraFragmentArgs by navArgs()


        usuario = bd.instance().usuarioDao().findById(args.usuarioId.toLong())

        binding.apply {
            NometextView.setText(usuario.nome)
            EmailtextView.setText(usuario.email)
            CidadetextView.setText(usuario.cidade)
            AnonascimentotextView.setText(usuario.anoNascimento.toString())
            CpftextView.setText(usuario.cpf.toString())
            ProfissaotextView.setText(usuario.profissao)

            ButVoltarDetalhes.setOnClickListener{
                Navigation.findNavController(it).navigate(DetalhesFragmentDirections.actionDetalhesFragmentToHomeFragment())
            }
        }
        return binding.root
    }


}