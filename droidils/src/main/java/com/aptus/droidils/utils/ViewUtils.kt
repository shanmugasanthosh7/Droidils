@file:Suppress("KDocUnresolvedReference", "unused")

package com.aptus.droidils.utils

import android.view.View

/** Show view*/
fun View.visible() {
    this.visibility = View.VISIBLE
}

/** Invisible view*/
fun View.inVisible() {
    this.visibility = View.INVISIBLE
}

/** Hide view*/
fun View.gone() {
    this.visibility = View.GONE
}

/** Returns [true] if view visible or else [false]*/
fun View.isVisible(): Boolean = this.visibility == View.VISIBLE

/** Returns [true] if view invisible or else [false]*/
fun View.isInVisible(): Boolean = this.visibility == View.INVISIBLE

/** Returns [true] if view gone or else [false]*/
fun View.isGone(): Boolean = this.visibility == View.GONE

/**
 * Returns View's tag with given Type [T]
 *
 * @exception ClassCastException
 * */
@Throws(ClassCastException::class)
inline fun <reified T> View.tag(): T? {
    val t = this.tag
    return if (t != null) this.tag as T else null
}

/**
 * Returns contentDescription as String
 */
fun View.contentDescription(): String = this.contentDescription.toString()