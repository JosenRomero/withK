package com.romero.withk.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.romero.withk.databinding.FragmentHomeBinding
import com.romero.withk.model.Note
import com.romero.withk.viewmodel.ItemViewModel

class HomeFragment : Fragment() {

    // FragmentHomeBinding - HomeFragment
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var adapter = HomeAdapter()
    private var itemViewModel: ItemViewModel = ItemViewModel()
    private var noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initRecyclerView()
        initRecyclerViewNotes()

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

    private fun initRecyclerViewNotes() {

        // recyclerview
        binding.recyclerViewNotes.adapter = noteAdapter
        binding.recyclerViewNotes.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        // example data
        val exampleData = ArrayList<Note>()
        exampleData.add(Note("example 1 title", "example 1 description"))
        exampleData.add(Note("example 2 title", "example 2 description"))
        exampleData.add(Note("example 3 title", "example 3 description"))
        exampleData.add(Note("example 4 title", "example 4 description"))
        noteAdapter.setNotes(exampleData)

    }

}