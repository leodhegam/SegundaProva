package com.tads.segundaprova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.tads.segundaprova.database.Bd
import com.tads.segundaprova.databinding.FragmentAlteraBinding
import com.tads.segundaprova.model.Usuario


class AlteraFragment : Fragment() {
    lateinit var usuario: Usuario
    lateinit var binding: FragmentAlteraBinding
    lateinit var bd: Bd

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)

        bd = Bd(inflater.context)

        val args: AlteraFragmentArgs by navArgs()

        usuario = bd.instance().usuarioDao().findById(args.usuarioId.toLong())


        binding.apply {
            nomeEdit.setText(usuario.nome)
            emailEdit.setText(usuario.email)
            cidadeEdit.setText(usuario.cidade)
            anoNascimentoEdit.setText(usuario.anoNascimento.toString())
            cpfEdit.setText(usuario.cpf.toString())
            profissaoEdit.setText(usuario.profissao)
            butAlterar.setOnClickListener {

                val nome = nomeEdit.text.toString()
                val email = emailEdit.text.toString()
                val cidade = cidadeEdit.text.toString()
                val anoNascimento = anoNascimentoEdit.text.toString().toInt()
                val cpf = cpfEdit.text.toString().toInt()
                val profissao = profissaoEdit.text.toString()

                bd.instance().usuarioDao().update(
                    Usuario(
                        args.usuarioId.toLong(),
                        nome,
                        email,
                        cidade,
                        anoNascimento,
                        cpf,
                        profissao
                    )
                )
                Navigation.findNavController(it)
                    .navigate(R.id.action_alteraFragment_to_homeFragment)
            }
            butVoltar.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_alteraFragment_to_homeFragment)
            }

        }
        return binding.root
    }
}