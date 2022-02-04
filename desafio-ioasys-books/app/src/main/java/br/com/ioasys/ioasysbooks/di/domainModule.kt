package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.domain.usecase.GetBookListUseCase
import br.com.ioasys.ioasysbooks.domain.usecase.LoginUseCase
import br.com.ioasys.ioasysbooks.domain.usecase.SaveBookListUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { LoginUseCase(get()) }
    factory { GetBookListUseCase(get()) }
    factory { SaveBookListUseCase(get()) }
}