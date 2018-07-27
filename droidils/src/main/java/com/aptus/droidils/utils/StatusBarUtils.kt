@file:Suppress("unused")

package com.aptus.droidils.utils

import android.app.Activity
import android.view.View
import android.view.WindowManager
import android.os.Build
import android.support.annotation.ColorRes
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat

/** Shows fullscreen*/
fun Activity.fullScreen() {
    this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

/** Exit fullscreen*/
fun Activity.exitFullScreen() {
    this.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

/** Shows fullscreen in immersive*/
fun Activity.fullScreenImmersive() {
    this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
}

/** Change status bar color with given resource [colorResId]*/
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.changeStatusBarColor(@ColorRes colorResId: Int) {
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = ContextCompat.getColor(this, colorResId)
}