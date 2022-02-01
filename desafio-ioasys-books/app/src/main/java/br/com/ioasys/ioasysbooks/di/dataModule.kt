package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.data.repositories.BooksRepositoryImpl
import br.com.ioasys.ioasysbooks.data.repositories.LoginRepositoryImpl
import br.com.ioasys.ioasysbooks.domain.repositories.BooksRepository
import br.com.ioasys.ioasysbooks.domain.repositories.LoginRepository
import org.koin.dsl.module

val dataModule = module {

    single<BooksRepository> {
        BooksRepositoryImpl(get(), get())
    }

    single<LoginRepository> {
        LoginRepositoryImpl(get(), get())
    }

}