package com.dokternak.dokternakid.utils.ext

import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.dokternak.dokternakid.R

@Suppress("DEPRECATION")
fun Fragment.showCustomToast(textAlert: String?) {
    val inflater = layoutInflater
    val layout = inflater.inflate(
        R.layout.layout_custom_toast,
        view?.findViewById(R.id.layout_custom_root)
    )
    val textView: TextView = layout.findViewById(R.id.txToastMessage)
    textView.text = textAlert
    with(Toast(context?.applicationContext)) {
        duration = Toast.LENGTH_SHORT
        setGravity(Gravity.CENTER or Gravity.BOTTOM, 0, 45)
        view = layout
        show()
    }
}

fun Fragment.showConfirmDialog(
    title: String,
    message: String,
    onPositiveClick:() -> Unit
){
    AlertDialog.Builder(requireContext()).apply {
        setTitle(title)
        setMessage(message)
        setNegativeButton(getString(R.string.action_cancel)) { p0, _ ->
            p0.dismiss()
        }
        setPositiveButton(getString(R.string.action_yes)) { _, _ ->
            onPositiveClick()
        }
    }.create().show()
}