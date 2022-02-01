package br.com.ioasys.ioasysbooks.data_remote.mappers

import br.com.ioasys.ioasysbooks.data_remote.model.LoginResponse
import br.com.ioasys.ioasysbooks.domain.model.User

fun LoginResponse.toDomain(accessToken: String) = User(
    name = this.name,
    birthdate = this.birthdate,
    gender = this.gender,
    accessToken = accessToken,
    id = this.id
)