package com.romero.withk.fragments.updateNote

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.romero.withk.R
import com.romero.withk.databinding.FragmentUpdateNoteBinding
import com.romero.withk.model.Note
import com.romero.withk.viewmodel.NoteViewModel

class UpdateNoteFragment : Fragment() {

    // FragmentUpdateNoteBinding - UpdateNoteFragment
    private var _binding: FragmentUpdateNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var noteViewModel: NoteViewModel

    // UpdateNoteFragmentArgs - UpdateNoteFragment
    private val args by navArgs<UpdateNoteFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateNoteBinding.inflate(inflater, container, false)

        // NoteViewModel
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        // if you need to understand the args.currentNote
        // see my_nav.xml argument and
        // see NoteAdapter.kt noteRowLayout.setOnClickListener
        binding.updateNoteName.setText(args.currentNote.title)

        // btn
        binding.btnUpdate.setOnClickListener {
            updateNoteToDatabase()
        }

        return binding.root

    }

    private fun updateNoteToDatabase() {

        val noteTitle: String = binding.updateNoteName.text.toString()

        if(!TextUtils.isEmpty(noteTitle)) {

            val note = Note(args.currentNote.id, noteTitle, "")

            // update current note in Database
            noteViewModel.updateNote(note)

            Toast.makeText(requireContext(), "update note!", Toast.LENGTH_LONG).show()

            // Navigate Back
            findNavController().navigate(R.id.action_updateNoteFragment_to_homeFragment)

        }else {
            Toast.makeText(requireContext(), "Please fill out name field", Toast.LENGTH_LONG).show()
        }

    }

}