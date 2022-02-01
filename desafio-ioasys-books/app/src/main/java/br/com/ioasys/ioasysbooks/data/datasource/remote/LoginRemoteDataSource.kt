package br.com.ioasys.ioasysbooks.data.datasource.remote

import br.com.ioasys.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow


interface LoginRemoteDataSource {

    fun login(email: String, password: String): Flow<User>
}