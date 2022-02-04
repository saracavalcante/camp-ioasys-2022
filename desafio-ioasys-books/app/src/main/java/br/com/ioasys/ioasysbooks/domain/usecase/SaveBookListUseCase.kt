package br.com.ioasys.ioasysbooks.domain.usecase

import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.domain.repositories.BooksRepository

class SaveBookListUseCase(
    private val booksRepository: BooksRepository
) {

    operator fun invoke(params: Params) = booksRepository.saveBooks(
        bookList = params.bookList
    )

    data class Params(
        val bookList: List<Book>
    )
}