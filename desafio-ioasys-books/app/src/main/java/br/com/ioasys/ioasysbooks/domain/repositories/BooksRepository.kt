package br.com.ioasys.ioasysbooks.domain.repositories

import br.com.ioasys.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getBooks(query: String?): Flow<List<Book>>
}