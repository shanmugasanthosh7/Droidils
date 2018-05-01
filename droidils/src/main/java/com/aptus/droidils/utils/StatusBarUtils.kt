@file:Suppress("unused")

package com.aptus.droidils.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager

fun Activity.fullScreen() {
    this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

fun Activity.exitFullScreen() {
    this.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

fun Activity.fullScreenImmersive(){
    this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
}