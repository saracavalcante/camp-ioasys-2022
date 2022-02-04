package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.presentation.viewmodel.LoginUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { LoginUseCase(get()) }
}