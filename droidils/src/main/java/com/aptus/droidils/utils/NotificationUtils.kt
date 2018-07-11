package com.aptus.droidils.utils

import android.app.Activity
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.support.annotation.RequiresApi


fun Context.getNotificationManager(): NotificationManager =
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

/**
 * Go to notification settings by channel id
 * */
@RequiresApi(api = Build.VERSION_CODES.O)
fun Activity.goToNotificationSettings(channel: String) {
    val i = Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS)
    i.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
    i.putExtra(Settings.EXTRA_CHANNEL_ID, channel)
    startActivity(i)
}

/**
 * Go to notification settings
 * */
@RequiresApi(api = Build.VERSION_CODES.O)
fun Activity.goToNotificationSettings() {
    val i = Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS)
    i.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
    startActivity(i)
}