@file:Suppress("unused")

package com.aptus.droidils.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


/**
 * GET Sharedpreference
 *
 * @param preferenceName
 */
fun Context.getSharedpreference(preferenceName:String): SharedPreferences {
    return getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
}

/**
 * GET DefaultSharedpreference
 */
fun Context.getDefaultSharedpreference(): SharedPreferences {
    return PreferenceManager.getDefaultSharedPreferences(this)
}