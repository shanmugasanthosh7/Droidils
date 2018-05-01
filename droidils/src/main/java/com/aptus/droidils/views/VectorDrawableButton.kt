package com.aptus.droidils.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v7.widget.AppCompatButton
import android.support.v4.graphics.drawable.DrawableCompat
import android.util.AttributeSet
import com.aptus.droidils.R

class VectorDrawableButton : AppCompatButton {

    private var drawableLeft: Int? = null

    private var drawableRight: Int? = null

    private var drawableTop: Int? = null

    private var drawableBottom: Int? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init(context, attributeSet)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        initAttrs(context, attributeSet!!)
    }

    private fun initAttrs(context: Context, attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.VectorDrawableButton)
        try {
            drawableLeft = ta.getResourceId(R.styleable.VectorDrawableButton_vdb_drawable_left, 0)
            drawableRight = ta.getResourceId(R.styleable.VectorDrawableButton_vdb_drawable_right, 0)
            drawableTop = ta.getResourceId(R.styleable.VectorDrawableButton_vdb_drawable_top, 0)
            drawableBottom = ta.getResourceId(R.styleable.VectorDrawableButton_vdb_drawable_bottom, 0)
            setVectorDrawableButton(drawableLeft!!, DrawablePosition.Left)
            setVectorDrawableButton(drawableRight!!, DrawablePosition.Right)
            setVectorDrawableButton(drawableTop!!, DrawablePosition.Top)
            setVectorDrawableButton(drawableBottom!!, DrawablePosition.Bottom)
        } finally {
            ta.recycle()
        }
    }

    /**
     * Support vector drawable in button
     *
     * @param drawableResId The drawable resource Id
     * @param position The position of the drawable placed in button
     * */
    fun setVectorDrawableButton(drawableResId: Int, position: DrawablePosition) {
        if (drawableResId != 0)
            setDrawableByPosition(wrapDrawable(convertResToVectorDrawable(drawableResId)!!), position)
    }

    private fun wrapDrawable(drawable: Drawable): Drawable = DrawableCompat.wrap(drawable)

    private fun convertResToVectorDrawable(drawableResId: Int): Drawable? = VectorDrawableCompat.create(resources, drawableResId, null)

    private fun setDrawableByPosition(drawable: Drawable, position: DrawablePosition) {
        when (position) {
            VectorDrawableButton.DrawablePosition.Left -> setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
            VectorDrawableButton.DrawablePosition.Bottom -> setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable)
            VectorDrawableButton.DrawablePosition.Right -> setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
            VectorDrawableButton.DrawablePosition.Top -> setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null)
        }
    }

    enum class DrawablePosition {
        Left, Right, Top, Bottom
    }
}