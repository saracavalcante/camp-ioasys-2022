package br.com.ioasys.ioasysbooks.data.datasource.remote

import br.com.ioasys.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRemoteDataSource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}