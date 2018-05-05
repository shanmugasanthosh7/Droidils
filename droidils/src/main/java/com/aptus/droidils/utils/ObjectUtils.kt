@file:Suppress("unused")

package com.aptus.droidils.utils

import com.google.gson.Gson
import com.google.gson.JsonElement

/**
 * Convert Object to Json
 *
 * @return Json String
 */
fun Any?.toJson(): String? = this?.let { Gson().toJson(this) }


/**
 * Convert Object to Json
 *
 * @return JsonElement
 */

fun <T> Any?.toJsonElement(): JsonElement = Gson().toJsonTree(this)
