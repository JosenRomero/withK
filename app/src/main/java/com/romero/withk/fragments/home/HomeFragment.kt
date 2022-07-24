package com.romero.withk.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.romero.withk.databinding.FragmentHomeBinding
import com.romero.withk.viewmodel.ItemViewModel

class HomeFragment : Fragment() {

    // FragmentHomeBinding - HomeFragment
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var adapter = HomeAdapter()
    private var itemViewModel: ItemViewModel = ItemViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {

        // recyclerview
        binding.recyclerViewItems.adapter = adapter
        binding.recyclerViewItems.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // itemViewModel
        itemViewModel.getAllItems()
        itemViewModel.items.observe(viewLifecycleOwner, Observer { data ->

            adapter.setItems(data)

        })

    }

}