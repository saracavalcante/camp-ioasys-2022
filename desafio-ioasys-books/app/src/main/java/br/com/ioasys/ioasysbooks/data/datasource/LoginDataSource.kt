package br.com.ioasys.ioasysbooks.data.datasource

import br.com.ioasys.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow


interface LoginDataSource {

    fun login(email: String, password: String): Flow<User>
}