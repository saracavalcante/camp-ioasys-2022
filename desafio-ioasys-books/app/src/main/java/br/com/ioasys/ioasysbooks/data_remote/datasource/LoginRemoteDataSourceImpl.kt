package br.com.ioasys.ioasysbooks.data_remote.datasource

import br.com.ioasys.ioasysbooks.data.datasource.remote.LoginRemoteDataSource
import br.com.ioasys.ioasysbooks.data_remote.mappers.toDomain
import br.com.ioasys.ioasysbooks.data_remote.model.LoginRequest
import br.com.ioasys.ioasysbooks.data_remote.service.AuthService
import br.com.ioasys.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRemoteDataSourceImpl(
    private val authService: AuthService
): LoginRemoteDataSource {

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