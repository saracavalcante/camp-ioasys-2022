package br.com.ioasys.ioasysbooks.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.ioasys.ioasysbooks.R
import br.com.ioasys.ioasysbooks.adapter.BookListAdapter
import br.com.ioasys.ioasysbooks.model.Book

class BookListActivity : AppCompatActivity() {

    private lateinit var bookListAdapter: BookListAdapter

    private val rvBooks: RecyclerView by lazy {
        findViewById(R.id.rvBooks)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        setBookListData()
    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter()
        rvBooks.adapter = bookListAdapter

        bookListAdapter.submitList(Book.getMockList())
    }
}