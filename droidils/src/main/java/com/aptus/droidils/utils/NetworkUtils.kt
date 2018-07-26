package com.aptus.droidils.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Returns ConnectivityManager
* */
fun Context.getConnectivityManager() : ConnectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

/**
 * Returns true if network is available or else false
 * */
fun Context.isNetworkConneted(): Boolean {
    val netInfo = getConnectivityManager().activeNetworkInfo
    return netInfo != null && netInfo.isConnectedOrConnecting
}