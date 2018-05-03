package com.aptus.droidils.utils

import android.content.Context
import android.net.ConnectivityManager


fun Context.getConnectivityManager() : ConnectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

fun Context.isNetworkConneted(): Boolean {
    val netInfo = getConnectivityManager().activeNetworkInfo
    return netInfo != null && netInfo.isConnectedOrConnecting
}