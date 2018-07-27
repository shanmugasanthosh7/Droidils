@file:Suppress("unused")

package com.aptus.droidils.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/** Returns SharedPreference with [preferenceName].*/
fun Context.getPref(preferenceName: String): SharedPreferences =
        getSharedPreferences(preferenceName, Context.MODE_PRIVATE)

/** Returns Default SharedPreference*/
fun Context.getDefaultPref(): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(this)

/** Returns SharedPreference Editor with [preferenceName].*/
@SuppressLint("CommitPrefEdits")
fun Context.getPrefEditor(preferenceName: String): SharedPreferences.Editor =
        this.getPref(preferenceName).edit()