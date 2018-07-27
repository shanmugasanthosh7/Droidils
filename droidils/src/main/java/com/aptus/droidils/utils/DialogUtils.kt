@file:Suppress("KDocUnresolvedReference")

package com.aptus.droidils.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import com.aptus.droidils.R

/**
 * Create simple [android.support.v7.app.AlertDialog]
 *
 * @param title Title of the dialog
 * @param message Message of the dialog
 * @param onButtonClick It trigger given method
 * @param isCancelable Dialog is cancellable or not, defaults to [true]
 * @param buttonText Text for positive button, defaults to [ok]
 */
inline fun Activity.simpleAlertDialog(title: String,
                                      message: String,
                                      crossinline onButtonClick:
                                      (dialog: DialogInterface?, which: Int) -> Unit,
                                      buttonText: String = "ok",
                                      isCancelable: Boolean = true): AlertDialog {
    val alertDialog = AlertDialog.Builder(this)
    alertDialog.setTitle(title)
    alertDialog.setMessage(message)
    alertDialog.setCancelable(isCancelable)
    alertDialog.setPositiveButton(buttonText) { dialog, which -> onButtonClick(dialog, which) }
    return alertDialog.create()
}

/**
 * Create simple [android.support.v7.app.AlertDialog]
 *
 * @param title Title of the dialog
 * @param message Message of the dialog
 * @param onPositiveButtonClick It trigger given method
 * @param onNegativeButtonClick It trigger given method
 * @param isCancelable Dialog is cancellable or not, defaults to [true]
 * @param positiveButtonText Text for positive button, defaults to [ok]
 * @param negativeButtonText Text for positive button, defaults to [Cancel]
 */
inline fun Activity.simpleAlertDialog(title: String,
                                      message: String,
                                      crossinline onPositiveButtonClick:
                                      (dialog: DialogInterface?, which: Int) -> Unit,
                                      crossinline onNegativeButtonClick:
                                      (dialog: DialogInterface?, which: Int) -> Unit,
                                      isCancelable: Boolean = true,
                                      positiveButtonText: String = "ok",
                                      negativeButtonText: String = "Cancel"): AlertDialog {
    val alertDialog = AlertDialog.Builder(this)
    alertDialog.setTitle(title)
    alertDialog.setMessage(message)
    alertDialog.setCancelable(isCancelable)
    alertDialog.setPositiveButton(positiveButtonText) { dialog, which ->
        onPositiveButtonClick(dialog, which)
    }
    alertDialog.setNegativeButton(negativeButtonText) { dialog, which ->
        onNegativeButtonClick(dialog, which)
    }
    return alertDialog.create()
}


/** Shows Progress Dialog with given [progressText]*/
@SuppressLint("InflateParams")
fun Activity.showProgressDialog(progressText: String): AlertDialog {
    val view = LayoutInflater.from(this).inflate(R.layout.progress_dialog, null)
    val text = view.findViewById(R.id.loadingText) as AppCompatTextView
    text.text = progressText
    val alertDialogBuilder = AlertDialog.Builder(this)
    alertDialogBuilder.setView(view)
    alertDialogBuilder.setCancelable(false)
    val progressDialog = alertDialogBuilder.create()
    progressDialog.show()
    return progressDialog
}