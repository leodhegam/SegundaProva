package com.tads.segundaprova

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.tads.segundaprova.database.Bd
import com.tads.segundaprova.databinding.FragmentCadastraBinding

class CadastraFragment : Fragment() {

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
            setHasOptionsMenu(true)
            return binding.root

        }

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.ajuda){
            var dialog = DialogFragment(R.layout.ajuda_cadastro)
            dialog.show(requireActivity().supportFragmentManager, "cadastro")
        }

        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(requireView()))||
                super.onOptionsItemSelected(item)
    }
}