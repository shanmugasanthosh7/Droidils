package com.aptus.droidils.utils

import android.view.View

/**
 * Show view
 * */
fun View?.visible() {
    this?.visibility = View.VISIBLE
}

/**
 * Invisible view
 * */
fun View?.inVisible(){
    this?.visibility = View.INVISIBLE
}

/**
 * Hide view
 * */
fun View?.gone(){
    this?.visibility = View.GONE
}

/**
 * Check whether the view is visible or not
 *
 * @return if visible {true} else {false}
 * */
fun View?.isVisible() : Boolean = this?.visibility == View.VISIBLE

/**
 * Check whether the view is invisible or not
 *
 * @return if invisible {true} else {false}
 * */
fun View?.isInVisible() : Boolean = this?.visibility == View.INVISIBLE

/**
 * Check whether the view is gone or not
 *
 * @return if gone {true} else {false}
 * */
fun View?.isGone() : Boolean = this?.visibility == View.GONE