package com.aptus.droidils.utils

import android.app.Activity
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.support.annotation.DrawableRes
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import com.aptus.droidils.R

/**
 * Returns NotificationManager
 * */
fun Context.getNotificationManager(): NotificationManager =
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

/**
 * Go to notification settings with [channelId]
 * */
@RequiresApi(api = Build.VERSION_CODES.O)
fun Activity.goToNotificationSettings(channelId: String) {
    val i = Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS)
    i.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
    i.putExtra(Settings.EXTRA_CHANNEL_ID, channelId)
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

/**
 * Create notification channel with [channelId], [channelName],
 * [isShowBadge] = true, [isEnableLights] = true, [isEnableVibration] = true
 * [importance] = IMPORTANCE_HIGH
 * */
@RequiresApi(api = Build.VERSION_CODES.O)
fun Context.createNotificationChannel(channelId: String,
                                      channelName: String,
                                      isShowBadge: Boolean = true,
                                      isEnableLights: Boolean = true,
                                      isEnableVibration: Boolean = true,
                                      importance: Int = NotificationManager.IMPORTANCE_HIGH) {
    val channel = NotificationChannel(channelId, channelName,
            importance)
    channel.setShowBadge(isShowBadge)
    channel.enableLights(isEnableLights)
    channel.enableVibration(isEnableVibration)
    getNotificationManager().createNotificationChannel(channel)
}

/**
 * Creates simple notification with [channelId], [contentTitle], [contentText],
 * [smallIcon] = com.aptus.droidils.R.drawable.ic_notifications,
 * [isAutoCancel] = true, [isOnGoing] = false
 * */
fun Context.simpleNotification(channelId: String,
                               contentTitle: String,
                               contentText: String,
                               @DrawableRes smallIcon: Int = R.drawable.ic_notifications,
                               isAutoCancel: Boolean = true,
                               isOnGoing: Boolean = false): Notification =
        NotificationCompat.Builder(this, channelId)
                .setSmallIcon(smallIcon)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setAutoCancel(isAutoCancel)
                .setOngoing(isOnGoing)
                .build()