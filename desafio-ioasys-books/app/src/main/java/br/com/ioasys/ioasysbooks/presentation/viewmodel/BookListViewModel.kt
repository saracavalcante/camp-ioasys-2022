package br.com.ioasys.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.domain.repositories.BooksRepository
import br.com.ioasys.ioasysbooks.util.ViewState
import br.com.ioasys.ioasysbooks.util.postError
import br.com.ioasys.ioasysbooks.util.postLoading
import br.com.ioasys.ioasysbooks.util.postSuccess
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BookListViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {

        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                booksRepository.getBooks(input).collect {
                    if (it.isEmpty().not()) {
                        _bookListViewState.postSuccess(it)
                    } else {
                        _bookListViewState.postError(Exception("Algo deu errado!"))
                    }
                }
            } catch (err: Exception) {
                _bookListViewState.postError(Exception(err))
            }
        }
    }
}