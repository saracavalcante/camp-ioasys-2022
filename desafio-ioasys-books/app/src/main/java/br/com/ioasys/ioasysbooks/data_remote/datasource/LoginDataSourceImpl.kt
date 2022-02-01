package br.com.ioasys.ioasysbooks.data_remote.datasource

import br.com.ioasys.ioasysbooks.data.datasource.LoginDataSource
import br.com.ioasys.ioasysbooks.data_remote.mappers.toDomain
import br.com.ioasys.ioasysbooks.data_remote.model.LoginRequest
import br.com.ioasys.ioasysbooks.data_remote.service.AuthService
import br.com.ioasys.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDataSourceImpl(
    private val authService: AuthService
): LoginDataSource {

    override fun login(email: String, password: String): Flow<User> = flow {
        val response = authService.singIn(LoginRequest(email, password))
        val accessToken = response.headers()["Authorization"]

        if (response.isSuccessful) {
            response.body()?.let { loginResponse ->
                emit(loginResponse.toDomain(accessToken ?: ""))
            }
        }
    }
}