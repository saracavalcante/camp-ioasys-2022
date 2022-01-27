package br.com.ioasys.ioasysbooks.data.datasource

import br.com.ioasys.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksDataSource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}