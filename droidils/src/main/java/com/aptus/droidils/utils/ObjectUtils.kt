@file:Suppress("unused")

package com.aptus.droidils.utils

import com.google.gson.Gson
import com.google.gson.JsonElement

/**
 * Returns Json String
 */
fun Any?.toJson(): String? = this?.let { Gson().toJson(this) }


/**
 *Returns JsonElement
 */

fun <T> Any?.toJsonElement(): JsonElement = Gson().toJsonTree(this)
