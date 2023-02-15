package com.dokternak.dokternakid.utils.ext

import android.Manifest
import android.app.Activity
import androidx.appcompat.app.AlertDialog
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlin.system.exitProcess

fun Activity.showExitAppDialog(
    title: String,
    message: String,
    positiveButtonText: String,
    negativeButtonText: String,
){
    AlertDialog.Builder(this.applicationContext).apply {
        setTitle(title)
        setMessage(message)
        setNegativeButton(negativeButtonText) { p0, _ ->
            p0.dismiss()
        }
        setPositiveButton(positiveButtonText) { _, _ ->
            finish()
            exitProcess(0)
        }
    }.create().show()
}

fun Activity.initiatePermissionTakePicture(onError: () -> Unit) {
    Dexter.withContext(this)
        .withPermissions(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        ).withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {}
            override fun onPermissionRationaleShouldBeShown(
                p0: MutableList<PermissionRequest>?,
                p1: PermissionToken?
            ) {
                p1?.continuePermissionRequest()
            }
        }).withErrorListener {
        }.onSameThread()
        .check()
}