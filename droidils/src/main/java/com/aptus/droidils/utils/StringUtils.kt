@file:Suppress("unused")

package com.aptus.droidils.utils

import android.net.Uri
import android.os.Build
import android.text.Html
import java.text.SimpleDateFormat
import java.util.*
import android.text.style.UnderlineSpan
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import android.text.style.SubscriptSpan
import android.text.style.SuperscriptSpan
import com.google.gson.GsonBuilder
import java.text.ParseException


object StringUtils {

    /** Generate GUID*/
    fun generateUUID(): String = UUID.randomUUID().toString()
}

/** Returns Uri */
fun String.toUri(): Uri = this.let { Uri.parse(this) }

/**
 * Returns parsed date with [parseDateFormat]. Default date format yyyy-MM-dd'T'hh:mm.
 *
 * @exception ParseException
 */
@Throws(ParseException::class)
fun String?.toParseDateTime(parseDateFormat: String = "yyyy-MM-dd'T'hh:mm"): Date? =
        this?.let { SimpleDateFormat(parseDateFormat, Locale.US).parse(this) }

/** Returns FirstLetter in uppercase.*/
fun String.toUpperCaseFirst(): String = this.let {
    val array = it.toCharArray()
    array[0] = Character.toUpperCase(array[0])
    return String(array)
}

/**
 * Change text to Superscript.
 *
 * @param startIndex Start index
 * @param endIndex End Index
 * @param superScriptTextSize Text size of the superscript, defaults to 0.5f
 */
fun String.toSuperScript(startIndex: Int, endIndex: Int, superScriptTextSize: Float = 0.5f) {
    val ss = SpannableString(this)
    ss.setSpan(SuperscriptSpan(), startIndex, endIndex, 0)
    ss.setSpan(RelativeSizeSpan(superScriptTextSize), startIndex, endIndex, 0)
}

/**
 * Change text to Subscript.
 *
 * @param startIndex Start index
 * @param endIndex End Index
 * @param subScriptTextSize Text size of the superscript, defaults to 0.5f
 */
fun String.toSubscript(startIndex: Int, endIndex: Int, subScriptTextSize: Float = 0.5f) {
    val ss = SpannableString(this)
    ss.setSpan(SubscriptSpan(), startIndex, endIndex, 0)
    ss.setSpan(RelativeSizeSpan(subScriptTextSize), startIndex, endIndex, 0)
}

/** Returns SpannableString. Change text to Underline.*/
fun String.toUnderline(): SpannableString {
    val ss = SpannableString(this)
    ss.setSpan(UnderlineSpan(), 0, this.length - 1, 0)
    return ss
}

/**
 * Returns SpannableString. Change text to Underline.
 *
 * @param startIndex Start index
 * @param endIndex End index
 * */
fun String.toUnderline(startIndex: Int, endIndex: Int): SpannableString {
    val ss = SpannableString(this)
    ss.setSpan(UnderlineSpan(), startIndex, endIndex, 0)
    return ss
}

/** Convert Html to String*/
@Suppress("DEPRECATION")
fun String.fromHtmlToString(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        Html.fromHtml(this, Html.FROM_HTML_SEPARATOR_LINE_BREAK_DIV or
                Html.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH or
                Html.FROM_HTML_MODE_COMPACT or
                Html.FROM_HTML_MODE_LEGACY)
    else
        Html.fromHtml(this)
}

/** Convert Json to Object*/
inline fun <reified T> String.toMappedObject(): T =
        this.let { GsonBuilder().create().fromJson(this, T::class.java) }

