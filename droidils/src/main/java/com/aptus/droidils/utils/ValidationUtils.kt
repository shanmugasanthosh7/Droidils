@file:Suppress("unused")

package com.aptus.droidils.utils

import java.util.regex.Pattern

object ValidationUtils {

    const val EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    const val EMAIL_PATTERN_2 = "^[a-z0-9_\\+-]+(\\.[a-z0-9_\\+-]+)*@[a-z0-9-]+(\\" +
            ".[a-z0-9-]+)*\\.([a-z]{2,4})$"
    const val EMAIL_PATTERN_3 = "^[a-zA-Z0-9,!#\\$%&'\\*\\+/=\\?\\^_`\\{\\|}~-]+(\\.[a-zA-Z0-9" +
            ",!#\\$%&'\\*\\+/=\\?\\^_`\\{\\|}~-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2,})$"

    /**
     * Validate password with regular expression
     *
     * (?=.*\\d)		#   must contains one digit from 0-9
     * (?=.*[a-z])		#   must contains one lowercase characters
     * (?=.*[A-Z])		#   must contains one uppercase characters
     * (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
     * #   match anything with previous condition checking
     * {6,20}	        #   length at least 6 characters and maximum of 20
     */
    const val PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"
}

/** Validate string with given [regexPattern]*/
fun String.validate(regexPattern: String): Boolean =
        Pattern.compile(regexPattern).matcher(this).matches()
