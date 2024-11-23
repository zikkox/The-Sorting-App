package com.example.thesortingapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesortingapp.data.Book
import com.example.thesortingapp.data.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BookViewModel : ViewModel(){
    private val repository = BookRepository()
    val bookFlow = MutableStateFlow<List<Book>>(emptyList())

    fun getBooks() = viewModelScope.launch {
        val booksList = repository.getBooksList()
        bookFlow.emit(booksList)
    }
}