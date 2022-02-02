package br.com.ioasys.ioasysbooks.data_local.data_base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.ioasys.ioasysbooks.data_local.model.BookDataLocal

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBooks(bookList: List<BookDataLocal>)

    @Query("SELECT * FROM Books")
    fun getBooks(): List<BookDataLocal>
}