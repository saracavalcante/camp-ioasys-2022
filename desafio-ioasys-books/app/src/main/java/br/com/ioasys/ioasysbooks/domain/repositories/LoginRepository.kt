package br.com.ioasys.ioasysbooks.domain.repositories

import br.com.ioasys.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun login(email: String, password: String): Flow<User>
}