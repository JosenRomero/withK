package com.romero.withk.fragments.updateNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.romero.withk.databinding.FragmentUpdateNoteBinding

class UpdateNoteFragment : Fragment() {

    // FragmentUpdateNoteBinding - UpdateNoteFragment
    private var _binding: FragmentUpdateNoteBinding? = null
    private val binding get() = _binding!!

    // UpdateNoteFragmentArgs - UpdateNoteFragment
    private val args by navArgs<UpdateNoteFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateNoteBinding.inflate(inflater, container, false)

        // if you need to understand the args.currentNote
        // see my_nav.xml argument and
        // see NoteAdapter.kt noteRowLayout.setOnClickListener
        binding.updateNoteName.setText(args.currentNote.title)

        return binding.root

    }

}