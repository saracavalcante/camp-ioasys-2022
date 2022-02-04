package br.com.ioasys.ioasysbooks.domain.usecase

import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.domain.repositories.BooksRepository
import br.com.ioasys.ioasysbooks.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SaveBookListUseCase(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope
) : UseCase<SaveBookListUseCase.Params, Unit>(scope = scope) {

    override fun run(params: Params?): Flow<Unit> = flowOf(
        booksRepository.saveBooks(
            bookList = params?.bookList ?: listOf()
        )
    )

    data class Params(
        val bookList: List<Book>
    )
}