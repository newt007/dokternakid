package com.dokternak.dokternakid.utils

import android.Manifest

object ConstVal {
    const val SPLASH_DELAY_TIME = 1500L

    const val PREFS_NAME = "sumbanginaja.pref"

    const val KEY_USER_ID = "key.user.id"
    const val KEY_USER_NAME = "key.user.name"
    const val KEY_IS_LOGIN = "key.isLogin"
    const val KEY_NAME = "key.name"
    const val KEY_ROLE = "key.role"
    const val KEY_PHONE_NUMBER = "key.phonenumber"
    const val KEY_TOKEN = "key.token"
    const val KEY_ADDRESS = "key.address"
    const val KEY_EMAIL = "key.email"

    const val JSON_ACCEPT = "application/json"

    const val DEFAULT_PAGE_INDEX = 1
    const val DEFAULT_PAGE_SIZE = 10

    val LOCATION_PERMISSION = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
}