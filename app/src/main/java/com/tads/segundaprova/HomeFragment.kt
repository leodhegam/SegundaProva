package com.tads.segundaprova

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.tads.segundaprova.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewmodel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        viewmodel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)


        val adapter = UsuarioAdapter()
        binding.recyclerUserView.adapter = adapter

        viewmodel.list.observe(viewLifecycleOwner, {
            adapter.usuarios = it
            adapter.notifyDataSetChanged()
        })


        binding.apply {

            val layout = LinearLayoutManager(
                parentFragment?.requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            recyclerUserView.layoutManager = layout

        }

        binding.recyclerUserView.addOnItemTouchListener(
            NovoRecyclerViewClickListener(
                this.requireActivity(),
                binding.recyclerUserView,

                object : NovoRecyclerViewClickListener.onItemClickListener {
                    override fun onItemClick(v: View, position: Int) {

                      Navigation.findNavController(requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(position+1))
                    }

                    override fun onItemLongClick(v: View, position: Int) {
                        Navigation.findNavController(requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(position+1))
                    }
                })
        )
        setHasOptionsMenu(true)

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.ajuda){
            var dialog = DialogFragment(R.layout.ajuda_home)
            dialog.show(requireActivity().supportFragmentManager, "cadastro")
        }

        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(requireView()))||
                super.onOptionsItemSelected(item)
    }
}