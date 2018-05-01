@file:Suppress("unused")

package com.aptus.droidils.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder


/**
 * Convert Json to Object
 *
 * @param json json String
 * @return Object
 */
inline fun <reified T> String.toJsonObject(): T = this.let { GsonBuilder().create().fromJson(this, T::class.java) }


/**
 * Convert Object to Json
 *
 * @param object Object
 * @return Json String
 */
fun Any?.toJson(): String? = this?.let { Gson().toJson(this) }
