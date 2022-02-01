package br.com.ioasys.ioasysbooks.data_local.data_source

import br.com.ioasys.ioasysbooks.data.datasource.local.BooksLocalDataSource
import br.com.ioasys.ioasysbooks.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import br.com.ioasys.ioasysbooks.data_local.utils.SharedPreferencesHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): BooksLocalDataSource {

    override fun getAccessToken(): Flow<String> = flow {
        emit(sharedPreferencesHelper.getString(ACCESS_TOKEN_KEY))
    }
}