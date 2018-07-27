package com.aptus.droidils.utils

import java.text.SimpleDateFormat
import java.util.*

/** Returns Formatted date with given [dateFormat]. Default to yyyy-MM-dd'T'hh:mm.*/
fun Date.toFormatDateTime(dateFormat: String = "yyyy-MM-dd'T'hh:mm"): String =
        this.let { SimpleDateFormat(dateFormat, Locale.US).format(this) }

/** Returns true if date is after or else false with given [toDate].*/
fun Date.isAfter(toDate: Date): Boolean = this.after(toDate)

/** Returns true if date is before or else false with given [toDate].*/
fun Date.isBefore(toDate: Date): Boolean = this.before(toDate)

