package com.aptus.droidils.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import com.aptus.droidils.R


/**
 * Shows simple dialog with [title], [message],
 * [isCancelable] = true, [buttonText] = ok and [onButtonClick]
 * */
inline fun Activity.simpleAlertDialog(title: String,
                                      message: String,
                                      crossinline onButtonClick:
                                      (dialog: DialogInterface?, which: Int) -> Unit,
                                      isCancelable: Boolean = true,
                                      buttonText: String = "ok"): AlertDialog {
    val alertDialog = AlertDialog.Builder(this)
    alertDialog.setTitle(title)
    alertDialog.setMessage(message)
    alertDialog.setCancelable(isCancelable)
    alertDialog.setPositiveButton(buttonText) { dialog, which -> onButtonClick(dialog, which) }
    return alertDialog.create()
}

/**
 * Shows simple dialog with [title], [message],
 * [isCancelable] = true, [positiveButtonText] = ok, [negativeButtonText] = Cancel
 * [onPositiveButtonClick] and [onNegativeButtonClick]
 * */
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


/**
 * Shows Progress Dialog with [progressText]
 * */
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