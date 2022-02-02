package br.com.ioasys.ioasysbooks.data.datasource.local

import br.com.ioasys.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    fun getAccessToken(): Flow<String>
    fun saveBooks(bookList: List<Book>)
    fun getBooks(query: String?): Flow<List<Book>>
}