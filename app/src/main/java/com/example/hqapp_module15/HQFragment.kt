package com.example.hqapp_module15

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.hqapp_module15.databinding.FragmentItemListBinding

/**
 * A fragment representing a list of Items.
 */
class HQFragment : Fragment(), HQItemListener {

    private lateinit var adapter: MyhqRecyclerViewAdapter
    private val viewModel by navGraphViewModels<HQViewModel>(R.id.hq_nav_graph) { defaultViewModelProviderFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentItemListBinding.inflate(inflater)
        val view = binding.root as RecyclerView

        val layoutManager = LinearLayoutManager(context)
        adapter = MyhqRecyclerViewAdapter(this@HQFragment)

        view.apply {
            this.adapter = this@HQFragment.adapter
            this.layoutManager = LinearLayoutManager(context)
        }
//        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
//                (activity as AppCompatActivity).setSupportActionBar(toolbar)

        initObservers()
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }
    private fun initObservers(){
        viewModel.hqListLiveData.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })
        viewModel.navigationToDetailLiveData.observe(viewLifecycleOwner, Observer {
            val action = HQFragmentDirections.actionHQFragmentToHQDetailsFragment()
            findNavController().navigate(action)
        })
    }

    override fun onItemSelected(position: Int) {
        viewModel.onHqSelected(position)
    }

}