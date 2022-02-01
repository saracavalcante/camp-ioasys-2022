package br.com.ioasys.ioasysbooks.domain.model

data class User(
    val name: String,
    val birthdate: String,
    val gender: String,
    val accessToken: String,
    val id: String
)
