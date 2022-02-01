package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.data.datasource.BooksDataSource
import br.com.ioasys.ioasysbooks.data.datasource.LoginDataSource
import br.com.ioasys.ioasysbooks.data_remote.datasource.BooksDataSoursceImpl
import br.com.ioasys.ioasysbooks.data_remote.datasource.LoginDataSourceImpl
import br.com.ioasys.ioasysbooks.data_remote.service.AuthService
import br.com.ioasys.ioasysbooks.data_remote.service.BookService
import br.com.ioasys.ioasysbooks.data_remote.utils.ApiConstants
import br.com.ioasys.ioasysbooks.data_remote.utils.WebServiceFactory
import org.koin.dsl.module

val dataRemoteModule = module {

    single<AuthService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single<BookService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single { WebServiceFactory.providerOkHttpClient() }

    single<BooksDataSource> {
        BooksDataSoursceImpl(get())
    }

    single<LoginDataSource> {
        LoginDataSourceImpl(get())
    }
}