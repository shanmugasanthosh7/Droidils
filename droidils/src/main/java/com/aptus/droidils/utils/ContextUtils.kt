@file:Suppress("unused")

package com.aptus.droidils.utils

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager

/** Returns InputMethodManager*/
fun Context.getInputMethodManager(): InputMethodManager =
        this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

/** Hide Keyboard*/
fun Context.hideKeyboard() {
    this.getInputMethodManager().hideSoftInputFromWindow(this.toActivity()
            .currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

/** Cast Context To Activity*/
fun Context.toActivity(): Activity = when {
    this is Activity -> this
    this is AppCompatActivity -> this
    else -> throw ClassCastException()
}


