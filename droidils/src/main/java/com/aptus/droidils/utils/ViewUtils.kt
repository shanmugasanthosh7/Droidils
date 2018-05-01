@file:Suppress("unused")

package com.aptus.droidils.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

/**
 * Hide Keyboard
 */
fun Context.hideKeyboard() {
    val inputManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow((this as Activity).currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

