package br.com.ioasys.ioasysbooks.presentation.ui.fragments

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ioasys.ioasysbooks.R
import br.com.ioasys.ioasysbooks.databinding.BottomSheetBookDetailsBinding
import br.com.ioasys.ioasysbooks.domain.model.Book
import coil.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookDetailsBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetBookDetailsBinding? = null
    private val binding: BottomSheetBookDetailsBinding get() = _binding!!

    private var book: Book? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = BottomSheetBookDetailsBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setListeners()
        setupBottomSheetHeight()
    }

    private fun setupBottomSheetHeight() {
        (dialog as BottomSheetDialog).behavior.state =
            BottomSheetBehavior.STATE_EXPANDED
    }

    private fun setListeners() {
        binding.btnClose.setOnClickListener {
            dismiss()
        }
    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }

    private fun setupView() {
        binding.apply {
            tvBookName.text = book?.title
            tvAuthors.text = book?.author
            tvInfoPages.text = book?.pages
            tvInfoEditor.text = book?.editor
            tvInfoDatePublication.text = book?.date
            tvInfoLanguage.text = book?.language
            tvInfoTitle.text = book?.title
            tvInfoISBN10.text = book?.isbn10
            tvInfoISBN13.text = book?.isbn13
            imgBigBook.load(book?.imageUrl) {
                error(R.drawable.book_image)
            }

            val spannableString = SpannableString("   ${book?.review}")
            val imageSpan = ImageSpan(requireContext(), R.drawable.ic_quotes)
            spannableString.setSpan(imageSpan, 0, 1, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
            tvReview.text = spannableString
        }
    }

    companion object {
        fun newInstance(book: Book? = null): BookDetailsBottomSheet {
            return BookDetailsBottomSheet().apply {
                this.book = book
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}