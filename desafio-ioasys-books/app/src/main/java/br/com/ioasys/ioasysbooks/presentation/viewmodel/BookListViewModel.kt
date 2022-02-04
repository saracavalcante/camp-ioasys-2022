package br.com.ioasys.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.domain.usecase.GetBookListUseCase
import br.com.ioasys.ioasysbooks.domain.usecase.SaveBookListUseCase
import br.com.ioasys.ioasysbooks.util.ViewState
import br.com.ioasys.ioasysbooks.util.postError
import br.com.ioasys.ioasysbooks.util.postLoading
import br.com.ioasys.ioasysbooks.util.postSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookListViewModel(
    private val getBookListUseCase: GetBookListUseCase,
    private val saveBookListUseCase: SaveBookListUseCase
) : ViewModel() {

    private var _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {
        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                withContext(Dispatchers.IO) {
                    getBookListUseCase(
                        params = GetBookListUseCase.Params(
                            input = input
                        )
                    ).collect {
                        saveBooks(bookList = it)
                        _bookListViewState.postSuccess(it)
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
                    saveBookListUseCase(
                        params = SaveBookListUseCase.Params(
                            bookList = bookList
                        )
                    )
                }
            } catch (err: Exception) {
                return@launch
            }
        }
    }
}