package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import br.com.ioasys.ioasysbooks.data.datasource.remote.LoginRemoteDataSource
import br.com.ioasys.ioasysbooks.data_remote.datasource.BooksRemoteDataSoursceImpl
import br.com.ioasys.ioasysbooks.data_remote.datasource.LoginRemoteDataSourceImpl
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

    single<BooksRemoteDataSource> {
        BooksRemoteDataSoursceImpl(get())
    }

    single<LoginRemoteDataSource> {
        LoginRemoteDataSourceImpl(get())
    }
}