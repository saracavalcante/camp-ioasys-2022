package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.presentation.viewmodel.BookListViewModel
import br.com.ioasys.ioasysbooks.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { BookListViewModel(get(), get()) }
}