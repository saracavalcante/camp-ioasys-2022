package br.com.ioasys.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.ioasysbooks.domain_model.exception.LoginException
import br.com.ioasys.ioasysbooks.util.ViewState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private var _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String ) {

        viewModelScope.launch {

            _loggedUserViewState.value = ViewState.loading

            delay(2_000)

            if (email.isNotEmpty() && password.isNotEmpty()) {
                _loggedUserViewState.value = ViewState.Success(true)
            } else {
                _loggedUserViewState.value = ViewState.Error(LoginException())
            }
        }
    }
}