package com.tads.segundaprova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.tads.segundaprova.databinding.FragmentCadastraBinding

class CadastraFragment : Fragment() {
    lateinit var viewmodel: CadastraFragmentViewModel
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewmodel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)
        return inflater.inflate(R.layout.fragment_cadastra, container, false)
    }
}