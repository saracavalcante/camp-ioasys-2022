package br.com.ioasys.ioasysbooks.data_remote.datasource

import br.com.ioasys.ioasysbooks.data.datasource.LoginDataSource
import br.com.ioasys.ioasysbooks.domain.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDataSourceImpl: LoginDataSource {
    override fun login(email: String, password: String): Flow<User> = flow {
        delay(3_000)

        emit(User(
            "Sara",
            "17/04/1997",
            "Female",
            "123456"
        ))
    }
}