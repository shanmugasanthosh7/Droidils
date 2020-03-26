@file:Suppress("unused")

package com.aptus.droidils.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View

/** Open default browser with the given [url].*/
fun Activity.urlActionView(url: String) {
    goTo { Intent(Intent.ACTION_VIEW, url.toUri()) }
}

/** Returns DisplayMetrics*/
fun Activity.getDisplayMetrics(): DisplayMetrics {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics
}

/** SetOnClickLister to view with given [views]*/
fun View.OnClickListener.setOnClickListener(vararg views: View) {
    views.forEach { it.setOnClickListener(this) }
}

/** Shows phone settings*/
fun Activity.showPhoneSettings() {
    startActivity(Intent(android.provider.Settings.ACTION_SETTINGS))
}

/** Start Activity with given [intent]*/
inline fun Activity.goTo(intent: () -> Intent) {
    startActivity(intent())
}

/**
 * Start Activity with given [intent]
 *
 * @param requestCode  Int: If >=0, this code will be returned in onActivityResult()
 * when the activity exits.
 */
inline fun Activity.goToWithResult(requestCode: Int, intent: () -> Intent) {
    startActivityForResult(intent(), requestCode)
}

/**
 * Start Activity with given [intent]
 *
 * @param requestCode  Int: If >=0, this code will be returned in onActivityResult()
 * when the activity exits.
 * @param options Bundle: Additional options for how the Activity should be started
 */
inline fun Activity.goToWithResult(requestCode: Int, options: Bundle, intent: () -> Intent) {
    startActivityForResult(intent(), requestCode, options)
}

/** Returns [Intent] with the given type [T]*/
inline fun <reified T> Activity.buildIntent(): Intent = Intent(this, T::class.java)

/** Returns [Intent] with the given type [T]
 *
 * @param [iAction] String: An action name, such as ACTION_VIEW. Application-specific actions
 * should be prefixed with the vendor's package name
 */
inline fun <reified T> Activity.buildIntent(iAction: String): Intent {
    val i = Intent(this, T::class.java)
    i.action = iAction
    return i
}