package br.com.ioasys.ioasysbooks.activity

import android.app.Application
import br.com.ioasys.ioasysbooks.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                presentationModule,
                dataModule,
                dataRemoteModule,
                dataLocalModule,
                dataBaseModule
            ).androidContext(applicationContext)
        }
    }
}