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

    private val itemTextSize: Float
    private val itemTextColor: Int
    private val itemBackgroundColor: Int
    private val itemPadding: Int

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.RectangleView,
            0, 0
        ).apply {
            try {
                itemTextSize = getDimension(R.styleable.LinearView_itemTextSize, 18f)
                itemTextColor = getColor(R.styleable.LinearView_itemTextColor, Color.BLACK)
                itemBackgroundColor = getColor(R.styleable.LinearView_itemBackgroundColor, Color.WHITE)
                itemPadding = getDimension(R.styleable.LinearView_itemPadding, 4f).toInt()
            } finally {
                recycle()
            }
        }
        addItem("Hello World")
    }

    fun addItem(item: String) {
        val textView = TextView(context)
        textView.apply {
            text = item
            textSize = itemTextSize
            setTextColor(itemTextColor)
            setBackgroundColor(itemBackgroundColor)
            setPadding(itemPadding, itemPadding, itemPadding, itemPadding)
        }
        addView(textView)
    }
}