package com.example.thesortingapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.thesortingapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       getCurrentBook()
    }

    private fun getCurrentBook(){
        val book = arguments?.let {
            DetailsFragmentArgs.fromBundle(it).book
        }

        book?.let {
            binding.titleTextView.text = it.attributes.title
            binding.summaryTextView.text = it.attributes.summary
            binding.dateTextView.text = it.attributes.releaseDate

            Glide.with(binding.coverImageView.context).load(it.attributes.cover)
                .into(binding.coverImageView)
        }
    }
}