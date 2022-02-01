package br.com.ioasys.ioasysbooks.data_remote.service

import br.com.ioasys.ioasysbooks.data_remote.model.LoginRequest
import br.com.ioasys.ioasysbooks.data_remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/sign-in")
    suspend fun singIn(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>
}