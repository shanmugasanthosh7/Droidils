package com.aptus.droidils.utils

import android.app.Activity
import android.content.Intent
import android.util.DisplayMetrics

fun Activity.urlActionView(url:String){
    val browserIntent = Intent(Intent.ACTION_VIEW, url.toUri())
    startActivity(browserIntent)
}

fun Activity.getDisplayMetrics(): DisplayMetrics {
    val displaymetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displaymetrics)
    return displaymetrics
}
