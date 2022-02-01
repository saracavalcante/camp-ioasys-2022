package br.com.ioasys.ioasysbooks.data.repositories

import br.com.ioasys.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val bookRemoteDataSource: BooksRemoteDataSource
): BooksRepository {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> =
        bookRemoteDataSource.getBooks(accessToken, query)
}