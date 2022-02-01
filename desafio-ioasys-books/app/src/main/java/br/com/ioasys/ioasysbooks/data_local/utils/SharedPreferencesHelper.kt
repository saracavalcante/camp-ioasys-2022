package br.com.ioasys.ioasysbooks.data_local.utils

import android.content.Context
import br.com.ioasys.ioasysbooks.data_local.utils.LocalConstants.SHARED_PREFERENCES_NAME

class SharedPreferencesHelper(
    context: Context
) {

    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_NAME,
        Context.MODE_PRIVATE
    )
}