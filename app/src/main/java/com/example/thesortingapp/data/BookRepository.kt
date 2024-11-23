package com.example.thesortingapp.data

class BookRepository {

    suspend fun getBooksList(): List<Book> {
        val retrofitInstance = RetrofitInstance()
        val createApi = retrofitInstance.createRetrofit().create(BookService::class.java)

        val response = createApi.getBooksList().body()
        return response?.data ?: emptyList()
    }
}