package br.com.ioasys.ioasysbooks.di

import androidx.room.Room
import br.com.ioasys.ioasysbooks.data_local.data_base.BookDataBase
import br.com.ioasys.ioasysbooks.data_local.utils.LocalConstants.BOOK_DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataBaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            BookDataBase::class.java,
            BOOK_DATABASE_NAME
        ).build()
    }

    single { get<BookDataBase>().bookDao() }
}