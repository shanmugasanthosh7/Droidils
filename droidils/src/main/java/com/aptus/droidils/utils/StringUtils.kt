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


/**
 * Convert String to Uri
 * @return String to Uri
 * */
fun String.toUri(): Uri = this.let { Uri.parse(this) }

/**
 * @param parseDateFormat The parse Date format eg.(yyyy-MM-dd'T'hh:mm).
 * @return Parsed date
 * */
@Throws(ParseException::class)
fun String?.toParseDateTime(parseDateFormat: String): Date? = this?.let { SimpleDateFormat(parseDateFormat, Locale.US).parse(this) }

/**
 * @return Given string first character convert into uppercase
 * */
fun String.toUpperCaseFirst(): String? = this.let {
    val array = it.toCharArray()
    array[0] = Character.toUpperCase(array[0])
    return String(array)
}

/**
 * Put Superscript
 * */
fun String.toSuperScript(startIndex: Int, endIndex: Int, superScriptTextSize: Float) {
    val ss = SpannableString(this)
    ss.setSpan(SuperscriptSpan(), startIndex, endIndex, 0)
    ss.setSpan(RelativeSizeSpan(superScriptTextSize), startIndex, endIndex, 0)
}

/**
 * Put Subscript
 * */
fun String.toSubscript(startIndex: Int, endIndex: Int, superScriptTextSize: Float) {
    val ss = SpannableString(this)
    ss.setSpan(SubscriptSpan(), startIndex, endIndex, 0)
    ss.setSpan(RelativeSizeSpan(superScriptTextSize), startIndex, endIndex, 0)
}

/**
 * Put Underline
 * */
fun String.toUnderline(): SpannableString {
    val ss = SpannableString(this)
    ss.setSpan(UnderlineSpan(), 0, this.length - 1, 0)
    return ss
}

/**
 * Put Underline
* */
fun String.toUnderline(startIndex: Int, endIndex: Int) : SpannableString{
    val ss = SpannableString(this)
    ss.setSpan(UnderlineSpan(), startIndex, endIndex, 0)
    return ss
}

/**
 * Convert Html to String
* */
@Suppress("DEPRECATION")
fun String.fromHtml(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        Html.fromHtml(this, Html.FROM_HTML_SEPARATOR_LINE_BREAK_DIV or
                Html.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH or Html.FROM_HTML_MODE_COMPACT or Html.FROM_HTML_MODE_LEGACY)
    else
        Html.fromHtml(this)
}

/**
 * Convert Json to Object
 *
 * @param json json String
 * @return Object
 */
inline fun <reified T> String.toJsonObject(): T = this.let { GsonBuilder().create().fromJson(this, T::class.java) }

