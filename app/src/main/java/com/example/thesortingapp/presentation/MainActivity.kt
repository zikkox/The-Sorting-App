package com.example.thesortingapp.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.thesortingapp.R
import com.example.thesortingapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter = BookAdapter()

    private val viewModel by viewModels<BookViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        initViews()
//        viewModel.getBooks()
//        setCollectors()
    }

//    private fun initViews(){
//        binding.recyclerview.adapter = adapter
//    }
//
//    private fun setCollectors() = lifecycleScope.launch {
//        viewModel.bookFlow.collect() { booksList ->
//            adapter.updateList(booksList)
//        }
//    }
}