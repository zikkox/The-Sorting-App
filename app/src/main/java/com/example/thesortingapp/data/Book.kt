package com.example.thesortingapp.data

import com.google.gson.annotations.SerializedName

data class BookResponse(
    val data: List<Book>
)

data class Book(
    val id: String,
    val type: String,
    val attributes: BookAttributes
)

data class BookAttributes(
    val cover: String,
    val pages: Int,
    @SerializedName("release_date")
    val releaseDate: String,
    val summary: String,
    val title: String
)
