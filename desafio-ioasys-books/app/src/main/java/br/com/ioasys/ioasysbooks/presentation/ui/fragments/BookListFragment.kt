package br.com.ioasys.ioasysbooks.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.ioasys.ioasysbooks.databinding.FragmentBookListBinding
import br.com.ioasys.ioasysbooks.domain.exception.EmptyBookListException
import br.com.ioasys.ioasysbooks.domain.model.Book
import br.com.ioasys.ioasysbooks.presentation.adapter.BookClickListener
import br.com.ioasys.ioasysbooks.presentation.adapter.BookListAdapter
import br.com.ioasys.ioasysbooks.presentation.viewmodel.BookListViewModel
import br.com.ioasys.ioasysbooks.util.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookListFragment : Fragment(), BookClickListener {

    private lateinit var bookListAdapter: BookListAdapter

    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!

    private val booksviewModel: BookListViewModel by viewModel()

    private val args: BookListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBookListData()
        configureListeners()
        addObserver()
    }

    private fun configureListeners() {
        binding.editSearch.textChangeListener = { input ->
            booksviewModel.search(input, args.accessToken)
        }
    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter(this)
        binding.rvBooks.adapter = bookListAdapter
        booksviewModel.search(accessToken = args.accessToken)
    }

    private fun addObserver() {
        booksviewModel.bookListViewState.observe(viewLifecycleOwner) { state ->

            when(state) {
                is ViewState.Success -> {
                    showEmptyError(false)
                    bookListAdapter.submitList(state.data)
                }
                is ViewState.Error -> {
                    when(state.throwable) {
                        is EmptyBookListException -> {
                            bookListAdapter.submitList(listOf())
                            showEmptyError(true)
                        }
                        else -> Unit
                    }
                }
                else -> Unit
            }
        }
    }

    private fun showEmptyError(hasError: Boolean) {
        binding.tvEmptyList.visibility = if (hasError) View.VISIBLE else View.GONE
    }

    override fun onBookClickListener(book: Book) {
        BookDetailsBottomSheet.newInstance(book).show(childFragmentManager, "book")
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}