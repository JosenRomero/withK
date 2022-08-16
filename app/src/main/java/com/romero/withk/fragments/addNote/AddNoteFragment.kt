package com.romero.withk.fragments.addNote

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.romero.withk.R
import com.romero.withk.databinding.FragmentAddNoteBinding
import com.romero.withk.model.Note
import com.romero.withk.viewmodel.NoteViewModel

class AddNoteFragment : Fragment() {

    // FragmentAddNoteBinding - AddNoteFragment
    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)

        // NoteViewModel
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        // btn
        binding.btnAdd.setOnClickListener {
            addNoteToDatabase()
        }

        return binding.root

    }

    private fun addNoteToDatabase() {

        val nameNote: String = binding.nameNote.text.toString()

        if(!TextUtils.isEmpty(nameNote)) {

            val newNote = Note(0, nameNote, "")

            // Add Note to Database
            noteViewModel.addNote(newNote)

            Toast.makeText(requireContext(), "new note!", Toast.LENGTH_LONG).show()

            // Navigate to homeFragment
            findNavController().navigate(R.id.action_addNoteFragment_to_homeFragment)

        } else {
            Toast.makeText(requireContext(), "Please fill out name field", Toast.LENGTH_LONG).show()
        }

    }

}