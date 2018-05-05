package com.aptus.droidils.utils

import android.app.Activity
import android.content.Intent
import android.util.DisplayMetrics
import android.view.View

fun Activity.urlActionView(url: String) {
    val browserIntent = Intent(Intent.ACTION_VIEW, url.toUri())
    startActivity(browserIntent)
}

fun Activity.getDisplayMetrics(): DisplayMetrics {
    val displaymetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displaymetrics)
    return displaymetrics
}

fun Activity.SetOnClickListener(clickListener: View.OnClickListener, vararg view: View) {
    view.forEach { it.setOnClickListener(clickListener) }
}
