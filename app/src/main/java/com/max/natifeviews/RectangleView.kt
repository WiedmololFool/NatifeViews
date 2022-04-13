package com.max.natifeviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class RectangleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private val paint = Paint()
    private val roundRadius: Float
    private val lineWidth: Float
    private val lineColor: Int
    private val halfLineWidth: Float

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.RectangleView,
            0, 0
        ).apply {
            try {
                roundRadius = getDimension(R.styleable.RectangleView_roundRadius, 0f)
                lineWidth = getDimension(R.styleable.RectangleView_lineWidth, 10f)
                lineColor = getColor(R.styleable.RectangleView_lineColor, Color.BLACK)
            } finally {
                recycle()
            }
        }
        paint.apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            strokeWidth = lineWidth
            color = lineColor
        }
        halfLineWidth = (lineWidth / 2f)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawRoundRect(
            halfLineWidth, halfLineWidth,
            width.toFloat() - halfLineWidth, height.toFloat() - halfLineWidth,
            roundRadius, roundRadius,
            paint
        )
    }
}