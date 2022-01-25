package br.com.ioasys.ioasysbooks.presentation.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.ioasysbooks.domain_model.exception.LoginException
import br.com.ioasys.ioasysbooks.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private var _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String ) {

        viewModelScope.launch {

            _loggedUserViewState.postLoading()

            delay(2_000)

            if (email.isNotEmpty() && password.isNotEmpty()) {
                _loggedUserViewState.postSuccess(true)
            } else {
                _loggedUserViewState.postError(LoginException())
            }
        }
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}