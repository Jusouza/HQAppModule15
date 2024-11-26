package com.example.hqapp_module15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.navGraphViewModels
import com.example.hqapp_module15.databinding.FragmentHqDetailsBinding

class HQDetailsFragment : Fragment() {

    private val viewModel by navGraphViewModels<HQViewModel>(R.id.hq_nav_graph){
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentHqDetailsBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_hq_details, container, false
            )

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }
}