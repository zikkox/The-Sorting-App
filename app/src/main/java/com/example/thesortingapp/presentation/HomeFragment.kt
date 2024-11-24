package com.example.thesortingapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.thesortingapp.data.Book
import com.example.thesortingapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    private val adapter by lazy {
        BookAdapter { clickedBook ->
            onBookClicked(clickedBook)
        }
    }

    private val viewModel by viewModels<BookViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        viewModel.getBooks()
        setCollectors()
    }

    private fun initViews(){
        binding.recyclerview.adapter = adapter
    }

    private fun setCollectors() = lifecycleScope.launch {
        viewModel.bookFlow.collect() { booksList ->
            adapter.updateList(booksList)
        }
    }

    private fun onBookClicked(book: Book) {
        val action = HomeFragmentDirections.actionHomeToDetail(book)
        findNavController().navigate(action)
    }
}