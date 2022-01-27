package br.com.ioasys.ioasysbooks.data.repositories

import br.com.ioasys.ioasysbooks.data.datasource.LoginDataSource
import br.com.ioasys.ioasysbooks.domain.model.User
import br.com.ioasys.ioasysbooks.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(
    private val loginDataSource: LoginDataSource
): LoginRepository {

    override fun login(email: String, password: String): Flow<User> =
        loginDataSource.login(email, password)
}