package com.example.thesortingapp.data

import retrofit2.http.GET

interface BookService {
    @GET("books")
    suspend fun getBooksList(): retrofit2.Response<BookResponse>
}