package br.com.ioasys.ioasysbooks.domain.usecase

import br.com.ioasys.ioasysbooks.domain.exception.InvalidEmailException
import br.com.ioasys.ioasysbooks.domain.exception.InvalidPasswordException
import br.com.ioasys.ioasysbooks.domain.model.User
import br.com.ioasys.ioasysbooks.domain.repositories.LoginRepository
import br.com.ioasys.ioasysbooks.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val loginRepository: LoginRepository,
    scope: CoroutineScope
) : UseCase<LoginUseCase.Params, User>(scope = scope) {

    override fun run(params: Params?): Flow<User> = when {
        params?.email?.isEmpty() == true -> throw InvalidEmailException()
        params?.password?.isEmpty() == true -> throw InvalidPasswordException()
        else -> {
            loginRepository.login(
                email = params?.email ?: "",
                password = params?.password ?: ""
            )
        }
    }

    data class Params(
        val email: String,
        val password: String
    )
}