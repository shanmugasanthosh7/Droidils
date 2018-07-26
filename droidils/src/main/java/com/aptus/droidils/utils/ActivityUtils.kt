package com.aptus.droidils.utils

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.support.annotation.RequiresApi
import android.util.DisplayMetrics
import android.view.View

/**
 * Url ActionView.
 * */
fun Activity.urlActionView(url: String) {
    startActivity(Intent(Intent.ACTION_VIEW, url.toUri()))
}

/**
 * Returns Displaymetrics
 * */
fun Activity.getDisplayMetrics(): DisplayMetrics {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics
}

/**
 * SetOnClickLister to all views
 * */
fun Activity.setOnClickListener(clickListener: View.OnClickListener, vararg view: View) {
    view.forEach { it.setOnClickListener(clickListener) }
}

/**
 *Shows phone settings
 * */
fun Activity.showPhoneSettings() {
    startActivity(Intent(android.provider.Settings.ACTION_SETTINGS))
}
