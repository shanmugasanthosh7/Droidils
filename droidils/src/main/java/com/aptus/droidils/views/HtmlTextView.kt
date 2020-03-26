package com.aptus.droidils.views

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import android.util.AttributeSet
import com.aptus.droidils.R
import com.aptus.droidils.utils.fromHtmlToString

class HtmlTextView : AppCompatTextView {

    private var htmlText: String? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init(context, attributeSet)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attributeSet, R.styleable.HtmlTextView)
        try {
            htmlText = ta.getNonResourceString(R.styleable.HtmlTextView_htv_html_text)
            htmlText?.let { setHtmlText(it)}
        } finally {
            ta.recycle()
        }
    }

    fun setHtmlText(htmlText: String) {
        text = htmlText.fromHtmlToString()
    }
}