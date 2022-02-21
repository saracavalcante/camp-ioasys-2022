package br.com.ioasys.ioasysbooks.data_remote.service

import br.com.ioasys.ioasysbooks.data_remote.model.BooksListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BookService {

    @GET("books")
    suspend fun getBooks(
        @Header("Authorization") accessToken: String,
        @Query("page") page: Int = 1,
        @Query("title") title: String = ""
    ): Response<BooksListResponse>
}