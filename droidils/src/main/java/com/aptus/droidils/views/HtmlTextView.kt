package com.aptus.droidils.views

import android.content.Context
import android.os.Build
import android.support.v7.widget.AppCompatTextView
import android.text.Html
import android.text.Spanned
import android.util.AttributeSet
import com.aptus.droidils.R

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
        text = formHtmlContent(htmlText)
    }

    @Suppress("DEPRECATION")
    private fun formHtmlContent(htmlContent: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            Html.fromHtml(htmlContent, Html.FROM_HTML_SEPARATOR_LINE_BREAK_DIV or
                    Html.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH or Html.FROM_HTML_MODE_COMPACT or Html.FROM_HTML_MODE_LEGACY)
        else
            Html.fromHtml(htmlContent)
    }
}