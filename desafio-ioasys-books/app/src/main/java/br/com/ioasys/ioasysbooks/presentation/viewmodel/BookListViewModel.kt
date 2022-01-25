package br.com.ioasys.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.ioasysbooks.domain_model.Book
import br.com.ioasys.ioasysbooks.domain_model.exception.EmptyBookListException
import br.com.ioasys.ioasysbooks.util.ViewState
import br.com.ioasys.ioasysbooks.util.postError
import br.com.ioasys.ioasysbooks.util.postSuccess
import kotlinx.coroutines.launch

class BookListViewModel : ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    private val bookDateList: List<Book> by lazy { Book.getMockList() }

    private fun getBooks(input: String): List<Book> {

        if (input.trim().isEmpty()) {
            return bookDateList
        } else {
            return bookDateList.filter { book ->
                book.name.trim().contains(input, ignoreCase = true)
            }
        }
    }

    fun search(input: String = "") {

        viewModelScope.launch {
            getBooks(input).let { books ->
                when {
                    books.isNotEmpty() -> {
                        _bookListViewState.postSuccess(books)
                    }
                    else -> {
                        _bookListViewState.postError(EmptyBookListException())
                    }
                }
            }
        }
    }
}