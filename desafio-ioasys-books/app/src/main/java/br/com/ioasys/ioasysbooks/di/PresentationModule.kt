package br.com.ioasys.ioasysbooks.di

import br.com.ioasys.ioasysbooks.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { LoginViewModel() }
}