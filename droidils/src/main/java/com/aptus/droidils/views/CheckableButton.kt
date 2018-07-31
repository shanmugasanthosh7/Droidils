package com.aptus.droidils.views

import android.content.Context
import android.widget.Checkable
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.view.View


class CheckableButton(context: Context,
                      attrs: AttributeSet) : AppCompatButton(context, attrs), Checkable {

    private var mChecked = false
    private var mOnCheckedChangeListener: OnCheckedChangeListener? = null

    override fun setChecked(checked: Boolean) {
        if (checked != mChecked) {
            mChecked = checked
            refreshDrawableState()
            if (mOnCheckedChangeListener != null) {
                mOnCheckedChangeListener!!.onCheckedChanged(this, mChecked)
            }
        }
    }

    override fun isChecked(): Boolean {
        return mChecked
    }

    override fun toggle() {
        isChecked = !mChecked
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        if (isChecked) {
            View.mergeDrawableStates(drawableState, CheckedStateSet)
        }
        return drawableState
    }

    override fun performClick(): Boolean {
        toggle()
        return super.performClick()
    }

    /**
     * Register a callback to be invoked when the checked state of this view changes.
     *
     * @param listener the callback to call on checked state change.
     */
    fun setOnCheckedChangeListener(listener: OnCheckedChangeListener) {
        mOnCheckedChangeListener = listener
    }

    /**
     * Interface definition for a callback to be invoked when the checked state of this View is
     * changed.
     */
    interface OnCheckedChangeListener {

        /**
         * Called when the checked state of a compound button has changed.
         *
         * @param checkableView The view whose state has changed.
         * @param isChecked     The new checked state of checkableView.
         */
        fun onCheckedChanged(checkableView: View, isChecked: Boolean)
    }

    companion object {

        private val CheckedStateSet = intArrayOf(android.R.attr.state_checked)
    }
}