package com.dokternak.dokternakid.utils.ext

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

fun Fragment.showConfirmDialog(
    title: String,
    message: String,
    positiveButtonText: String,
    onPositiveClick:() -> Unit,
    negativeButtonText: String,
){
    AlertDialog.Builder(requireContext()).apply {
        setTitle(title)
        setMessage(message)
        setNegativeButton(negativeButtonText) { p0, _ ->
            p0.dismiss()
        }
        setPositiveButton(positiveButtonText) { _, _ ->
            onPositiveClick()
        }
    }.create().show()
}

fun Fragment.showOkDialog(
    title: String,
    message: String,
    positiveButtonText: String,
    ) {
    AlertDialog.Builder(requireContext()).apply {
        setTitle(title)
        setMessage(message)
        setPositiveButton(positiveButtonText) { dialog, _ ->
            dialog.dismiss()
        }
    }.create().show()
}