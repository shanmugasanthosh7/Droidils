@file:Suppress("unused")

package com.aptus.droidils.utils

import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText

/**
 * Sets IME ACTION and it's Listener with given [actionId]
 *
 * @param actionId Action Id for IME, defaults to [EditorInfo.IME_ACTION_GO]
 * @param actionBody Action is done by this function.
 */
inline fun EditText.setImeActionListener(actionId: Int = EditorInfo.IME_ACTION_GO,
                                         crossinline actionBody:
                                         (v: View?, event: KeyEvent?) -> Boolean) {
    this.imeOptions = actionId
    this.setOnEditorActionListener { v, acId, event ->
        return@setOnEditorActionListener if (actionId == acId) actionBody(v, event) else false
    }
}

/** Returns EditText's text as string*/
fun EditText.text(): String = this.text.toString()

/**
 * Add TextChangeListener with given functions [beforeTextChange], [onTextChange]
 * and [afterTextChange]
 */
inline fun EditText.onTextWatcher(crossinline beforeTextChange: (s: CharSequence?,
                                                                 start: Int,
                                                                 count: Int,
                                                                 after: Int) -> Unit,
                                  crossinline onTextChange: (s: CharSequence?,
                                                             start: Int,
                                                             before: Int,
                                                             count: Int) -> Unit,
                                  crossinline afterTextChange: (s: Editable?) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            beforeTextChange(s, start, count, after)
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChange(s, start, before, count)
        }

        override fun afterTextChanged(s: Editable?) {
            afterTextChange(s)
        }
    })
}

/** EditText TextWatcherListener with given function [beforeTextChange]*/
inline fun EditText.onBeforeTextChange(crossinline beforeTextChange: (s: CharSequence?,
                                                                      start: Int,
                                                                      count: Int,
                                                                      after: Int) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            beforeTextChange(s, start, count, after)
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
        }
    })
}

/** EditText TextWatcherListener with given function [onTextChange]*/
inline fun EditText.onTextChange(crossinline onTextChange: (s: CharSequence?,
                                                            start: Int,
                                                            before: Int,
                                                            count: Int) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChange(s, start, before, count)
        }

        override fun afterTextChanged(s: Editable?) {
        }
    })
}

/** EditText TextWatcherListener with given function [afterTextChange]*/
inline fun EditText.onAfterTextChange(crossinline afterTextChange: (s: Editable?) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            afterTextChange(s)
        }
    })
}