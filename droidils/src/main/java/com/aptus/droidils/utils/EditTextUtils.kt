package com.aptus.droidils.utils

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