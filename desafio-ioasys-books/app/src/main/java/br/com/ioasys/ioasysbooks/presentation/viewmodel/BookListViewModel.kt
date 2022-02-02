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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookListViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {
        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                withContext(Dispatchers.IO) {
                    booksRepository.getBooks(input).collect {
                        withContext(Dispatchers.Main) {
                            if (it.isNotEmpty()) {
                                saveBooks(bookList = it)
                                _bookListViewState.postSuccess(it)
                            } else {
                                _bookListViewState.postError(Exception("Algo deu errado!"))
                            }
                        }
                    }
                }
            } catch (err: Exception) {
                withContext(Dispatchers.Main) {
                    _bookListViewState.postError(err)
                }
            }
        }
    }

    private fun saveBooks(bookList: List<Book>) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    booksRepository.saveBooks(bookList = bookList)
                }
            } catch (err: Exception) {
                return@launch
            }
        }
    }
}