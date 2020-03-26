@file:Suppress("unused")

package com.aptus.droidils.utils

import android.content.Context
import android.util.Log

/** Returns Class's SimpleName with given type [T]*/
inline fun <reified T> logTag(): String? = T::class.java.simpleName

/** Prints given [message] in console*/
inline fun <reified T> Context.logDebug(message: String) {
    Log.d(logTag<T>(), message)
}

/** Prints given [message] in console*/
inline fun <reified T> Context.logError(message: String) {
    Log.e(logTag<T>(), message)
}

/** Prints given [message] in console*/
inline fun <reified T> Context.logWarning(message: String) {
    Log.w(logTag<T>(), message)
}

/** Prints given [message] in console*/
inline fun <reified T> Context.logInfo(message: String) {
    Log.i(logTag<T>(), message)
}

/** Prints given [message] in console*/
inline fun <reified T> Context.logVerbose(message: String) {
    Log.v(logTag<T>(), message)
}