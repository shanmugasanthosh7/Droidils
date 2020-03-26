@file:Suppress("unused")

package com.aptus.droidils.utils

import android.content.Intent
import android.util.SparseArray
import android.content.pm.ShortcutManager
import android.os.Build
import androidx.annotation.RequiresApi
import android.content.pm.ShortcutInfo
import android.content.Context
import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.annotation.NonNull
import java.util.*

/** Returns ShortCutManager */
@RequiresApi(api = Build.VERSION_CODES.N_MR1)
fun Context.getShortCutManager(): ShortcutManager? = getSystemService(ShortcutManager::class.java)

/**
 * Build shortcut with the given [appShortCut].
 *
 * @param rank Shortcut rank, defaults to [0].
 *
 * @exception AppShortCutLabelLengthException Short label and long label exceed more 10 and 25
 * character.
 */
@RequiresApi(api = Build.VERSION_CODES.N_MR1)
@Throws(AppShortCutLabelLengthException::class)
fun Context.buildShortCut(appShortCut: AppShortCut,
                          rank: Int = 0): ShortcutInfo {
    when {
        (appShortCut.isEnableLongLabel
                && appShortCut.longLabel != null
                && appShortCut.longLabel!!.length > 25) ->
            throw AppShortCutLabelLengthException("More than 25 character not allowed " +
                    "in Long Label")
        (appShortCut.shortLabel.length > 10) ->
            throw AppShortCutLabelLengthException("More than 10 character not allowed " +
                    "in Short Label")
    }
    val shortCutBuilder = ShortcutInfo.Builder(this, appShortCut.id)
            .setShortLabel(appShortCut.shortLabel)
            .setRank(rank)
            .setIcon(Icon.createWithResource(this, appShortCut.iconRes))
            .setIntents(appShortCut.intents)
    if (appShortCut.isEnableLongLabel) appShortCut.longLabel?.let { shortCutBuilder.setLongLabel(it) }
    return shortCutBuilder.build()
}

/**
 * Build shortcuts with the given [appShortCuts].
 *
 * @exception AppShortCutLimitException Publish only four distinct shortcuts.
 */
@RequiresApi(api = Build.VERSION_CODES.N_MR1)
@Throws(AppShortCutLimitException::class)
fun Context.buildShortCuts(appShortCuts: SparseArray<AppShortCut>): List<ShortcutInfo> {
    val length = appShortCuts.size()
    if (length > 4)
        throw AppShortCutLimitException("ShortCut Not allow more than 4 items and it's recommended")
    val shortcutInfos = ArrayList<ShortcutInfo>()
    for (i in 0 until length) shortcutInfos.add(buildShortCut(appShortCuts.get(i), i))
    return shortcutInfos
}

/** Set shortcuts with the given [shortcutInfos].*/
@RequiresApi(api = Build.VERSION_CODES.N_MR1)
fun Context.setShortCuts(shortcutInfos: List<ShortcutInfo>) {
    getShortCutManager()?.dynamicShortcuts = shortcutInfos
}

/** Disable shortcuts with the given [shortcutIds].*/
@RequiresApi(api = Build.VERSION_CODES.N_MR1)
fun Context.disableShortCuts(shortcutIds: List<String>?) {
    val shortcutManager = getShortCutManager()
    if (shortcutManager != null && (shortcutIds != null && shortcutIds.isNotEmpty()))
        shortcutManager.disableShortcuts(shortcutIds)
}

/** Returns Shortcut Id with the given [appShortCuts].*/
fun Context.getShortCutIds(appShortCuts: SparseArray<AppShortCut>): List<String> {
    val length = appShortCuts.size()
    val id = ArrayList<String>()
    var appShortCut: AppShortCut
    for (i in 0 until length) {
        appShortCut = appShortCuts.get(i)
        id.add(appShortCut.id)
    }
    return id
}

data class AppShortCut(@NonNull val id: String,
                       @NonNull val shortLabel: String,
                       @DrawableRes val iconRes: Int,
                       @NonNull val intents: Array<Intent>,
                       var longLabel: String? = null,
                       var isEnableLongLabel: Boolean = false) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AppShortCut

        if (!intents.contentEquals(other.intents)) return false

        return true
    }

    override fun hashCode(): Int = intents.contentHashCode()
}

class AppShortCutLimitException(message: String) : RuntimeException(message)

class AppShortCutLabelLengthException(message: String) : RuntimeException(message)