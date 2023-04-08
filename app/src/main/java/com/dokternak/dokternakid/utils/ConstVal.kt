package com.dokternak.dokternakid.utils

import android.Manifest

object ConstVal {
    const val SPLASH_DELAY_TIME = 1500L

    const val PREFS_NAME = "sumbanginaja.pref"

    const val KEY_FARMER_ID = "key.farmer.id"
    const val KEY_USER_ID = "key.user.id"
    const val KEY_USER_NAME = "key.user.name"
    const val KEY_IS_LOGIN = "key.isLogin"
    const val KEY_NAME = "key.name"
    const val KEY_ROLE = "key.role"
    const val KEY_PHONE_NUMBER = "key.phonenumber"
    const val KEY_TOKEN = "key.token"
    const val KEY_PASSWORD = "key.password"
    const val KEY_ADDRESS = "key.address"
    const val KEY_EMAIL = "key.email"
    const val KEY_PROFILE_PICTURE = "key.profilePicture"
    const val KEY_GENDER = "key.gender"

    const val JSON_ACCEPT = "application/json"

    const val DEFAULT_PAGE_INDEX = 1
    const val DEFAULT_PAGE_SIZE = 10

    val LOCATION_PERMISSION = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    const val ARTICLE_IMAGE_BASE_URL = "https://www.dokternak.id/public/data/data_artikel/"
    const val OFFICER_IMAGE_BASE_URL = "https://www.dokternak.id/public/data/data_dokter/"
    const val FARMER_IMAGE_BASE_URL = "https://www.dokternak.id/public/data/data_peternak/"
    const val PUSKESWAN_IMAGE_BASE_URL = "https://www.dokternak.id/public/data/data_puskeswan/"

    val tabTitle = listOf("Konsultasi Masuk", "Konsultasi Terkirim")

    const val INBOX_CONSULTATION = "inbox"
    const val SENT_CONSULTATION = "sent"

    const val OFFICER_REQUEST_KEY = "101"
    const val REFRESH_REQUEST_KEY = "102"
    const val EDIT_REQUEST_KEY = "103"

}