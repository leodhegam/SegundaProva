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
import com.tads.segundaprova.database.Bd
import com.tads.segundaprova.databinding.FragmentAlteraBinding


class AlteraFragment : Fragment() {
    lateinit var viewmodel: CadastraFragmentViewModel
    lateinit var binding : FragmentAlteraBinding
    lateinit var bd: Bd

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_altera,container,false)
        bd = Bd(inflater.context)
        viewmodel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)
        return inflater.inflate(R.layout.fragment_altera, container, false)


    }

}