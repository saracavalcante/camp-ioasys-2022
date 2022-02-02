package br.com.ioasys.ioasysbooks.data_local.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.ioasys.ioasysbooks.data_local.model.BookDataLocal

@Database(entities = [BookDataLocal::class], version = 1)
abstract class BookDataBase: RoomDatabase() {

    abstract fun bookDao(): BookDao
}