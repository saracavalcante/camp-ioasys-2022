package br.com.ioasys.ioasysbooks.domain.repositories

import br.com.ioasys.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getBooks(query: String?, page: Int, title: String): Flow<List<Book>>
    fun saveBooks(bookList: List<Book>)
}