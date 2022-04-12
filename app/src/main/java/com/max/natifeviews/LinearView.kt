package com.max.natifeviews

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class LinearView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defstyle: Int = 0
) : LinearLayout(context, attrs, defstyle) {

    private val textSize: Float
    private val textColor: Int
    private val backgroundColor: Int
    private val padding: Int

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.RectangleView,
            0, 0
        ).apply {
            try {
                textSize = getDimension(R.styleable.LinearView_textSize, 18f)
                textColor = getColor(R.styleable.LinearView_textColor, Color.BLACK)
                backgroundColor = getColor(R.styleable.LinearView_backgroundColor, Color.WHITE)
                padding = getDimension(R.styleable.LinearView_padding, 4f).toInt()
            } finally {
                recycle()
            }
        }
        addItem("Hello World")
    }

    fun addItem(item: String) {
        val textView = TextView(context)
        textView.setTextColor(Color.BLACK)
        textView.text = item
        textView.textSize = textSize
        textView.setTextColor(textColor)
        textView.setBackgroundColor(backgroundColor)
        textView.setPadding(padding, padding, padding, padding)
        addView(textView)
    }
}