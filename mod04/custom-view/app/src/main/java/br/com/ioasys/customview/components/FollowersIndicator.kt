package br.com.ioasys.customview.components

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import br.com.ioasys.customview.R
import br.com.ioasys.customview.databinding.ResFollowersIndicatorBinding

class FollowersIndicator(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val binding: ResFollowersIndicatorBinding = ResFollowersIndicatorBinding.inflate(
        LayoutInflater.from(context), this, true)

    init {
        context.obtainStyledAttributes(attrs, R.styleable.FollowersIndicator).apply {
            getString(R.styleable.FollowersIndicator_counter)?.let { setCounter(it) }
            getString(R.styleable.FollowersIndicator_indicator)?.let { setCounter(it) }
            setBold(getBoolean(R.styleable.FollowersIndicator_bold, true))
        }
    }

    fun setCounter(count: String) {
        this.binding.tvCounter.text = count
    }

    fun setIndicator(indicator: String) {
        this.binding.tvIndicator.text = indicator
    }

    fun setBold(isBold: Boolean) {
        if (isBold) {
            this.binding.tvCounter.typeface = Typeface.DEFAULT_BOLD
        } else {
            this.binding.tvCounter.typeface = Typeface.DEFAULT
        }
    }
}