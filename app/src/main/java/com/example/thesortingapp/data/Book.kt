package com.example.thesortingapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookResponse(
    val data: List<Book>
) : Parcelable

@Parcelize
data class Book(
    val id: String,
    val type: String,
    val attributes: BookAttributes
) : Parcelable

@Parcelize
data class BookAttributes(
    val cover: String,
    val pages: Int,
    @SerializedName("release_date")
    val releaseDate: String,
    val summary: String,
    val title: String
) : Parcelable
