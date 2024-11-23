package com.example.thesortingapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thesortingapp.data.Book
import com.example.thesortingapp.data.BookDiffCallback
import com.example.thesortingapp.databinding.ItemBookBinding

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var booksList = listOf<Book>()

    class BookViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            //binding.titleTextview.text = book.title

            Glide.with(binding.coverImageview.context).load(book.attributes.cover)
                .into(binding.coverImageview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = booksList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(booksList[position])
    }


    fun updateList(newBooksList: List<Book>){
        val diffCallback = BookDiffCallback(booksList, newBooksList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        booksList = newBooksList
        diffResult.dispatchUpdatesTo(this)
    }
}