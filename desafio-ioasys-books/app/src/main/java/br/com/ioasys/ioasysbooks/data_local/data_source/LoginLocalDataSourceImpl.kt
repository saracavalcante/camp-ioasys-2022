package br.com.ioasys.ioasysbooks.data_local.data_source

import br.com.ioasys.ioasysbooks.data.datasource.local.LoginLocalDataSource
import br.com.ioasys.ioasysbooks.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import br.com.ioasys.ioasysbooks.data_local.utils.SharedPreferencesHelper

class LoginLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): LoginLocalDataSource {

    override fun saveAccessToken(accessToken: String) = sharedPreferencesHelper.saveString(
        key = ACCESS_TOKEN_KEY,
        value = accessToken
    )
}