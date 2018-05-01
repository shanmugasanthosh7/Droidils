@file:Suppress("unused")

package com.aptus.droidils.utils

import android.net.Uri
import java.text.SimpleDateFormat
import java.util.*
import android.text.style.UnderlineSpan
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.text.style.SubscriptSpan
import android.text.style.SuperscriptSpan


/**
 * Convert String to Uri
 * @return String to Uri
 * */
fun String.toUri(): Uri = this.let { Uri.parse(this) }

/**
 * @param parseDateFormat The parse Date format eg.(yyyy-MM-dd'T'hh:mm).
 * @return Parsed date
 * */
fun String.toParseDateTime(parseDateFormat: String): Date = this.let { SimpleDateFormat(parseDateFormat, Locale.US).parse(this) }

/**
 * @return Given string first character convert into uppercase
 * */
fun String.toUpperCaseFirst(): String? = this.let {
    val array = it.toCharArray()
    array[0] = Character.toUpperCase(array[0])
    return String(array)
}

fun String.toSuperScript(startIndex: Int, endIndex: Int, superScriptTextSize: Float) {
    val ss = SpannableString(this)
    ss.setSpan(SuperscriptSpan(), startIndex, endIndex, 0)
    ss.setSpan(RelativeSizeSpan(superScriptTextSize), startIndex, endIndex, 0)
}

fun String.toSubScript(startIndex: Int, endIndex: Int, superScriptTextSize: Float) {
    val ss = SpannableString(this)
    ss.setSpan(SubscriptSpan(), startIndex, endIndex, 0)
    ss.setSpan(RelativeSizeSpan(superScriptTextSize), startIndex, endIndex, 0)
}

fun String.toUnderline() : SpannableString {
    val ss = SpannableString(this)
    ss.setSpan(UnderlineSpan(), 0, this.length - 1, 0)
    return ss
}

fun String.toUnderline(startIndex: Int, endIndex: Int) {
    val ss = SpannableString(this)
    ss.setSpan(UnderlineSpan(), startIndex, endIndex, 0)
}

