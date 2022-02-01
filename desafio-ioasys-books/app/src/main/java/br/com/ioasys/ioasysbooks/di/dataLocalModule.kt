package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.data_local.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {

    single { SharedPreferencesHelper(androidContext()) }

}