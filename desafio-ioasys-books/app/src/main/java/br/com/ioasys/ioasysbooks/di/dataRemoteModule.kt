package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.data.datasource.BooksDataSource
import br.com.ioasys.ioasysbooks.data.datasource.LoginDataSource
import br.com.ioasys.ioasysbooks.data_remote.datasource.BooksDataSoursceImpl
import br.com.ioasys.ioasysbooks.data_remote.datasource.LoginDataSourceImpl
import org.koin.dsl.module

val dataRemoteModule = module {

    single<BooksDataSource> {
        BooksDataSoursceImpl()
    }

    single<LoginDataSource> {
        LoginDataSourceImpl()
    }
}