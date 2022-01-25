package br.com.ioasys.ioasysbooks.util

import android.view.View

sealed class ViewState<out T> {

    object loading: ViewState<Nothing>()

    data class Success<T>(
        val data: T
    ) : ViewState<T>()

    data class Error(
        val throwable: Throwable
    ) : ViewState<Nothing>()

    object Neutral: ViewState<Nothing>()
}