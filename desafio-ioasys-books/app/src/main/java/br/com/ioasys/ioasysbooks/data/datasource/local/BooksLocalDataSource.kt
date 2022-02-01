package br.com.ioasys.ioasysbooks.data.datasource.local

import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    fun getAccessToken(): Flow<String>
}