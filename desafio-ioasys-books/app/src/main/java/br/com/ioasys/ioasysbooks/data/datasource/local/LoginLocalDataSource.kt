package br.com.ioasys.ioasysbooks.data.datasource.local

interface LoginLocalDataSource {

    fun saveAccessToken(accessToken: String)

}