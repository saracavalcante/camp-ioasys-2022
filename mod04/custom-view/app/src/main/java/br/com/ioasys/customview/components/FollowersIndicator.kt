package br.com.ioasys.customview.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import br.com.ioasys.customview.databinding.ResFollowersIndicatorBinding

class FollowersIndicator(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val binding: ResFollowersIndicatorBinding = ResFollowersIndicatorBinding.inflate(
        LayoutInflater.from(context), this, true)

    init {

    }
}