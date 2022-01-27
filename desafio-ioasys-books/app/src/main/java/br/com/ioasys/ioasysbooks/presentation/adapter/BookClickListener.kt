package br.com.ioasys.ioasysbooks.presentation.adapter

import br.com.ioasys.ioasysbooks.domain.model.Book

interface BookClickListener {

    fun onBookClickListener(book: Book) {

    }
}