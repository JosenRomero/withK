package com.romero.withk.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.romero.withk.databinding.FragmentHomeBinding
import com.romero.withk.model.Item

class HomeFragment : Fragment() {

    // FragmentHomeBinding - HomeFragment
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var adapter = HomeAdapter()

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

        // adding example data
        val itemExample = ArrayList<Item>()
        itemExample.add(Item("example 1 title", "example 1 img"))
        itemExample.add(Item("example 2 title", "example 2 img"))
        itemExample.add(Item("example 3 title", "example 3 img"))
        itemExample.add(Item("example 4 title", "example 4 img"))
        adapter.setItems(itemExample)

    }

}