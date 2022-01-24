package br.com.ioasys.ioasysbooks.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import br.com.ioasys.ioasysbooks.presentation.adapter.BookClickListener
import br.com.ioasys.ioasysbooks.presentation.adapter.BookListAdapter
import br.com.ioasys.ioasysbooks.databinding.FragmentBookListBinding
import br.com.ioasys.ioasysbooks.model.Book

class BookListFragment : Fragment(), BookClickListener {

    private val args: BookListFragmentArgs by navArgs()

    private lateinit var bookListAdapter: BookListAdapter

    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBookListData()
        args.itemCount
    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter(this)
        binding.rvBooks.adapter = bookListAdapter

        bookListAdapter.submitList(Book.getMockList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onBookClickListener(book: Book) {
        BookDetailsBottomSheet.newInstance(book).show(childFragmentManager, "book")
    }
}