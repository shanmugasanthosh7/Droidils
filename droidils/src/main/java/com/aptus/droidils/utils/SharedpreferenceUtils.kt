@file:Suppress("unused")

package com.aptus.droidils.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


/**
 * GET Sharedpreference
 *
 * @param preferenceName
 */
fun Context.getPref(preferenceName:String): SharedPreferences {
    return getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
}

/**
 * GET DefaultSharedpreference
 */
fun Context.getDefaultPref(): SharedPreferences {
    return PreferenceManager.getDefaultSharedPreferences(this)
}


@SuppressLint("CommitPrefEdits")
fun Context.getPrefEditor(preferenceName:String) : SharedPreferences.Editor = this.getPref(preferenceName).edit()