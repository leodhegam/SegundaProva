package com.tads.segundaprova

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
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

            buttonCadastrar.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_homeFragment_to_cadastraFragment)
            }

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

                      Navigation.findNavController(requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(1+position))
                    }

                    override fun onItemLongClick(v: View, position: Int) {
                        TODO("Not yet implemented")
                    }
                })
        )
        return binding.root
    }
}