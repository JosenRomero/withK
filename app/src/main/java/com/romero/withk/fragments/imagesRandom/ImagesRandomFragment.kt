package com.romero.withk.fragments.imagesRandom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.romero.withk.databinding.FragmentImagesRandomBinding
import com.romero.withk.viewmodel.ItemViewModel

class ImagesRandomFragment : Fragment() {

    // FragmentImagesRandomBinding - ImagesRandomFragment
    private var _binding: FragmentImagesRandomBinding? = null
    private val binding get() = _binding!!

    private var imagesAdapter = ImagesAdapter()
    private var itemViewModel: ItemViewModel = ItemViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentImagesRandomBinding.inflate(inflater, container, false)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {

        // recyclerview
        binding.recyclerViewImages.adapter = imagesAdapter
        binding.recyclerViewImages.layoutManager = LinearLayoutManager(requireContext())

        // itemViewModel
        itemViewModel.getAllItems(1, 12)
        itemViewModel.items.observe(viewLifecycleOwner, Observer {  data ->

            imagesAdapter.setImages(data)

        })

    }

}