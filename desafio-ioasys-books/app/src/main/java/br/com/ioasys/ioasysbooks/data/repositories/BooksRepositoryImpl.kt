package br.com.ioasys.ioasysbooks.data.repositories

import br.com.ioasys.ioasysbooks.data.datasource.BooksDataSource
import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val bookDataSource: BooksDataSource
): BooksRepository {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> =
        bookDataSource.getBooks(accessToken, query)
}