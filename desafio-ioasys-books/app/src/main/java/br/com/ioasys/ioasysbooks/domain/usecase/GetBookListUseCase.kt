package br.com.ioasys.ioasysbooks.domain.usecase

import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class GetBookListUseCase(
   private val booksRepository: BooksRepository
) {

    operator fun invoke(params: Params): Flow<List<Book>> = booksRepository.getBooks(
        query = params.input
    )

    data class Params(
        val input: String
    )
}