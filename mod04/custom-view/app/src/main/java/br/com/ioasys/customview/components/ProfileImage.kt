package br.com.ioasys.customview.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import br.com.ioasys.customview.databinding.ResProfileImageBinding

class ProfileImage(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val binding: ResProfileImageBinding = ResProfileImageBinding.inflate(
        LayoutInflater.from(context), this, true)

    init {

    }

}