package br.com.ioasys.ioasysbooks.data_remote.datasource

import br.com.ioasys.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import br.com.ioasys.ioasysbooks.data_remote.mappers.toDomain
import br.com.ioasys.ioasysbooks.data_remote.service.BookService
import br.com.ioasys.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksRemoteDataSoursceImpl(
    private val bookService: BookService
): BooksRemoteDataSource {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {
        val response = bookService.getBooks(accessToken = "Bearer $accessToken", page = 1)
        if (response.isSuccessful) {
            response.body()?.data?.let { bookList ->
                query?.let {
                    emit(bookList.filter { book ->
                        book.title?.trim()?.contains(it, ignoreCase = true) ?: false
                    }.toDomain())
                } ?: run {
                    emit(bookList.toDomain())
                }
            }
        }
    }
}