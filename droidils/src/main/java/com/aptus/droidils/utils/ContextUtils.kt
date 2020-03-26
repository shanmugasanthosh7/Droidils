@file:Suppress("unused")

package com.aptus.droidils.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.SensorManager
import android.media.AudioManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager

/** Returns InputMethodManager*/
fun Context.getInputMethodManager(): InputMethodManager =
        this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

/** Returns AudioManager*/
fun Context.getAudioManger(): AudioManager =
        this.getSystemService(Context.AUDIO_SERVICE) as AudioManager

/** Returns SensorManager*/
fun Context.getSensorManger(): SensorManager =
        this.getSystemService(Context.SENSOR_SERVICE) as SensorManager

/** Hide Keyboard*/
fun Context.hideKeyboard() {
    this.getInputMethodManager().hideSoftInputFromWindow(this.toActivity()
            .currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

/** Cast Context To Activity*/
fun Context.toActivity(): Activity = when {
    this is Activity -> this
    this is AppCompatActivity -> this
    else -> throw ClassCastException()
}

/** Compat StartService*/
fun Context.compatStartService(service: Intent) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) startForegroundService(service)
    else startService(service)
}

/**
 * Share Text using chooser
 *
 * @param subject Subject.
 * @param message Text which has to shared.
 * @param chooserTitle Title for chooser, defaults to Share via
 * */
fun Context.shareText(subject: String, message: String, chooserTitle: String = "Share via") {
    val i = Intent(Intent.ACTION_SEND)
    i.type = "text/plain"
    i.putExtra(Intent.EXTRA_SUBJECT, subject)
    i.putExtra(Intent.EXTRA_TEXT, message)
    startActivity(Intent.createChooser(i, chooserTitle))
}

/**
 * Share Photo using chooser
 *
 * @param photoUri Uri for photo.
 * @param chooserTitle Title for chooser, defaults to Share via
 * */
fun Context.sharePhoto(photoUri: Uri, chooserTitle: String = "Share via") {
    val intent = Intent(Intent.ACTION_SEND)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    intent.putExtra(Intent.EXTRA_STREAM, photoUri)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    intent.type = "image/*"
    startActivity(Intent.createChooser(intent, chooserTitle))
}


