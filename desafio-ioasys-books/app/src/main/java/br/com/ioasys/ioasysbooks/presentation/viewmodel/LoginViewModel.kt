package br.com.ioasys.ioasysbooks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.ioasysbooks.domain.exception.LoginException
import br.com.ioasys.ioasysbooks.domain.repositories.LoginRepository
import br.com.ioasys.ioasysbooks.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginRepository: LoginRepository
): ViewModel() {

    private var _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String ) {

        viewModelScope.launch {
            _loggedUserViewState.postLoading()

            try {
                loginRepository.login(email, password).collect {
                    if (it.name.isEmpty().not()) {
                        _loggedUserViewState.postSuccess(true)
                    } else {
                        _loggedUserViewState.postError(Exception("Body do usuário vazio!"))
                    }
                }
            } catch (err: Exception) {
                _loggedUserViewState.postError(err)

            }
        }
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}