package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.data.datasource.local.BooksLocalDataSource
import br.com.ioasys.ioasysbooks.data.datasource.local.LoginLocalDataSource
import br.com.ioasys.ioasysbooks.data_local.data_source.BooksLocalDataSourceImpl
import br.com.ioasys.ioasysbooks.data_local.data_source.LoginLocalDataSourceImpl
import br.com.ioasys.ioasysbooks.data_local.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {

    single { SharedPreferencesHelper(androidContext()) }
    single<LoginLocalDataSource> { LoginLocalDataSourceImpl(get()) }
    single<BooksLocalDataSource> { BooksLocalDataSourceImpl(get()) }
}