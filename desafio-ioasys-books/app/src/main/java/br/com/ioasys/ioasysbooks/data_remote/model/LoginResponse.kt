package br.com.ioasys.ioasysbooks.data_remote.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("birthdate")
    val birthdate: String,
    @SerializedName("gender")
    val gender: String
)