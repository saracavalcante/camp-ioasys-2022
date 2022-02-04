package br.com.ioasys.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.domain.usecase.GetBookListUseCase
import br.com.ioasys.ioasysbooks.domain.usecase.SaveBookListUseCase
import br.com.ioasys.ioasysbooks.util.ViewState
import br.com.ioasys.ioasysbooks.util.postError
import br.com.ioasys.ioasysbooks.util.postLoading
import br.com.ioasys.ioasysbooks.util.postSuccess

class BookListViewModel(
    private val getBookListUseCase: GetBookListUseCase,
    private val saveBookListUseCase: SaveBookListUseCase
) : ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {
        _bookListViewState.postLoading()
        getBookListUseCase(
            params = GetBookListUseCase.Params(
                input = input
            ),
            onSuccess = {
                saveBooks(bookList = it)
                _bookListViewState.postSuccess(it)
            },
            onError = {
                _bookListViewState.postError(it)
            }
        )
    }

    private fun saveBooks(bookList: List<Book>) {
        saveBookListUseCase(
            params = SaveBookListUseCase.Params(
                bookList = bookList
            )
        )
    }
}