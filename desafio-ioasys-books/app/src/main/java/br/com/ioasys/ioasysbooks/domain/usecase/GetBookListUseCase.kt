package br.com.ioasys.ioasysbooks.domain.usecase

import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.domain.repositories.BooksRepository
import br.com.ioasys.ioasysbooks.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetBookListUseCase(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope,
) : UseCase<GetBookListUseCase.Params, List<Book>>(scope = scope) {

    override fun run(params: Params?): Flow<List<Book>> {
        return if (params != null) {
            booksRepository.getBooks(
                query = params.input,
                page = params.page,
                title = params.title
            )
        } else {
            booksRepository.getBooks(
                query = params?.input,
                page = 10,
                title = ""
            )
        }
    }

    data class Params(
        val input: String,
        val page: Int,
        val title: String,
    )
}