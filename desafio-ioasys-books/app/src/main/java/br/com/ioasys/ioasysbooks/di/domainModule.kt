package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.domain.usecase.GetBookListUseCase
import br.com.ioasys.ioasysbooks.domain.usecase.LoginUseCase
import br.com.ioasys.ioasysbooks.domain.usecase.SaveBookListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {

    single {
        CoroutineScope(Dispatchers.IO)
    }

    factory { LoginUseCase(get(), get()) }
    factory { GetBookListUseCase(get(), get()) }
    factory { SaveBookListUseCase(get(), get()) }
}