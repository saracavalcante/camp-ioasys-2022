package br.com.ioasys.ioasysbooks.data.repositories

import br.com.ioasys.ioasysbooks.data.datasource.local.BooksLocalDataSource
import br.com.ioasys.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class BooksRepositoryImpl(
    private val bookRemoteDataSource: BooksRemoteDataSource,
    private val booksLocalDataSource: BooksLocalDataSource
): BooksRepository {

    override fun getBooks(query: String?, page: Int, title: String): Flow<List<Book>> = flow {
        booksLocalDataSource.getAccessToken().collect { token ->
            if (token.isNotEmpty()) {
                bookRemoteDataSource.getBooks(token, query, page, title).collect { bookList ->
                    emit(bookList)
                }
            } else {
                booksLocalDataSource.getBooks(query = query).collect { bookList ->
                    emit(bookList)
                }
            }
        }
    }

    override fun saveBooks(bookList: List<Book>) = booksLocalDataSource.saveBooks(
        bookList = bookList
    )
}