package com.tads.segundaprova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.tads.segundaprova.database.Bd
import com.tads.segundaprova.databinding.FragmentCadastraBinding

class CadastraFragment : Fragment() {
    lateinit var repository: UsuarioRepository
    lateinit var viewmodel: CadastraFragmentViewModel
    lateinit var binding: FragmentCadastraBinding
    lateinit var bd: Bd
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewmodel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        bd = Bd(inflater.context)

        binding.apply {
            butcadastrar.setOnClickListener {
                viewmodel.usuarios.nome = nomeEdit.text.toString()

                viewmodel.usuarios.email = emailEdit.text.toString()

                viewmodel.usuarios.cidade = cidadeEdit.text.toString()

                viewmodel.usuarios.cpf = cpfEdit.text.toString().toInt()

                viewmodel.usuarios.anoNascimento = anoNascimentoEdit.text.toString().toInt()

                viewmodel.usuarios.profissao = profissaoEdit.toString()

                bd.instance().usuarioDao().insert(viewmodel.usuarios)

                Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)
            }
            return binding.root

        }


    }
}