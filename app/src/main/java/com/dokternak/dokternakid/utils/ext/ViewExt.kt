package com.dokternak.dokternakid.utils.ext

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dokternak.dokternakid.R
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.snackbar.Snackbar

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.disable() {
    isEnabled = false
}

fun View.enabled() {
    isEnabled = true
}

fun ImageView.setImageUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.color.colorSoftGrey)
        .into(this)
}

infix fun View.click(click: () -> Unit) {
    setOnClickListener {
        click()
    }
}

infix fun View.popClick(click: () -> Unit) {
    setOnClickListener {
        it.popTap()
        Handler(Looper.getMainLooper()).postDelayed({
            click()
        }, 200)
    }
}

fun EditText.showError(message: String) {
    error = message
    requestFocus()
}

fun showLoading(loadingView: View, view: View) {
    loadingView.show()
    view.show()
}

fun showLoading(loadingView: View) {
    loadingView.show()
}

fun hideLoading(loadingView: View, view: View) {
    loadingView.gone()
    view.gone()
}

fun hideLoading(loadingView: View) {
    loadingView.gone()
}

fun EditText.showMessage(errorMessage: String) {
    requestFocus()
    error = errorMessage
}

fun View.popTap(){
    this.visibility = View.VISIBLE
    this.alpha = 1.0f

    this.pivotX = (this.width / 2).toFloat()
    this.pivotY = (this.height / 2).toFloat()

    val scaleDownX = ObjectAnimator.ofFloat(this, "scaleX", 0.7f)
    val scaleDownY = ObjectAnimator.ofFloat(this, "scaleY", 0.7f)

    scaleDownX.duration = 100
    scaleDownY.duration = 100

    val scaleUpX = ObjectAnimator.ofFloat(this, "scaleX", 1.0f)
    val scaleUpY = ObjectAnimator.ofFloat(this, "scaleY", 1.0f)

    scaleUpX.duration = 100
    scaleUpY.duration = 100

    val scaleDown = AnimatorSet()
    scaleDown.play(scaleDownX).with(scaleDownY)
    scaleDown.start()

    val scaleUp = AnimatorSet()
    scaleUp.play(scaleUpX).with(scaleUpY).after(scaleDown)
    scaleUp.start()
}

fun View.showSnackBar(message: String) {
    Snackbar.make(
        this,
        message,
        Snackbar.LENGTH_LONG
    ).also { snackbar ->
        snackbar.setAction("Ok") {
            snackbar.dismiss()
        }
    }.show()
}

fun startShimmerLoading(loadingContainer: ShimmerFrameLayout, recyclerView: RecyclerView) {
    loadingContainer.show()
    loadingContainer.startShimmer()
    recyclerView.gone()
}

fun stopShimmerLoading(loadingContainer: ShimmerFrameLayout, recyclerView: RecyclerView) {
    loadingContainer.gone()
    recyclerView.show()
}