package com.aptus.droidils.utils

import android.app.Activity
import android.content.Intent
import android.util.DisplayMetrics
import android.view.View

/** Open default browser with the given [url].*/
fun Activity.urlActionView(url: String) {
    startActivity(Intent(Intent.ACTION_VIEW, url.toUri()))
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
