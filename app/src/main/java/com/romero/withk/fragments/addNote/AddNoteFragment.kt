package com.romero.withk.fragments.addNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.romero.withk.R
import com.romero.withk.databinding.FragmentAddNoteBinding

class AddNoteFragment : Fragment() {

    // FragmentAddNoteBinding - AddNoteFragment
    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)

        return binding.root

    }

}