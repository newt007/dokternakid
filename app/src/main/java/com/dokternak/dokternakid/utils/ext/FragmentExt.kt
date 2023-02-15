package com.dokternak.dokternakid.utils.ext

import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
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