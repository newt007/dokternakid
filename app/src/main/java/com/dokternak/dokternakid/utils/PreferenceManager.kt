package com.dokternak.dokternakid.utils

import android.content.Context
import android.content.SharedPreferences
import com.dokternak.dokternakid.domain.membership.model.User
import com.dokternak.dokternakid.utils.ConstVal.KEY_ADDRESS
import com.dokternak.dokternakid.utils.ConstVal.KEY_EMAIL
import com.dokternak.dokternakid.utils.ConstVal.KEY_FARMER_ID
import com.dokternak.dokternakid.utils.ConstVal.KEY_GENDER
import com.dokternak.dokternakid.utils.ConstVal.KEY_IS_LOGIN
import com.dokternak.dokternakid.utils.ConstVal.KEY_NAME
import com.dokternak.dokternakid.utils.ConstVal.KEY_PASSWORD
import com.dokternak.dokternakid.utils.ConstVal.KEY_PHONE_NUMBER
import com.dokternak.dokternakid.utils.ConstVal.KEY_PROFILE_PICTURE
import com.dokternak.dokternakid.utils.ConstVal.KEY_TOKEN
import com.dokternak.dokternakid.utils.ConstVal.KEY_USER_ID
import com.dokternak.dokternakid.utils.ConstVal.KEY_USER_NAME
import com.dokternak.dokternakid.utils.ext.emptyString

class PreferenceManager(context: Context) {

    private var prefs: SharedPreferences =
        context.applicationContext.getSharedPreferences(ConstVal.PREFS_NAME, Context.MODE_PRIVATE)
    private val editor = prefs.edit()

    fun setStringPreference(prefKey: String, value: String) {
        editor.putString(prefKey, value)
        editor.apply()
    }

    fun setBooleanPreference(prefKey: String, value: Boolean) {
        editor.putBoolean(prefKey, value)
        editor.apply()
    }

    fun clearPreferenceByKey(prefKey: String) {
        editor.remove(prefKey)
        editor.apply()
    }

    fun setLoginPref(userItem: User, password: String) {
        userItem.let {
            setStringPreference(KEY_FARMER_ID, it.farmerId.toString())
            setStringPreference(KEY_USER_ID, it.id)
            setStringPreference(KEY_EMAIL, it.email)
            setStringPreference(KEY_USER_NAME, it.name)
            setBooleanPreference(KEY_IS_LOGIN, true)
            setStringPreference(KEY_PROFILE_PICTURE, userItem.farmPicture)
            setStringPreference(KEY_GENDER, it.gender)
            setStringPreference(KEY_ADDRESS, it.address)
            setStringPreference(KEY_PHONE_NUMBER, it.phoneNumber)
            setStringPreference(KEY_PASSWORD, password)
        }
    }

    fun editProfilePref(
        name: String,
        password: String,
        email: String,
        phoneNumber: String,
        gender: String,
        address: String,
        profilePicture: String
    ) {
        setStringPreference(KEY_EMAIL, email)
        setStringPreference(KEY_USER_NAME, name)
        setStringPreference(KEY_PROFILE_PICTURE, profilePicture)
        setStringPreference(KEY_GENDER, gender)
        setStringPreference(KEY_ADDRESS, address)
        setStringPreference(KEY_PHONE_NUMBER, phoneNumber)
        setStringPreference(KEY_PASSWORD, password)
    }

    fun clearAllPreferences() {
        editor.remove(KEY_USER_ID)
        editor.remove(KEY_USER_NAME)
        editor.remove(KEY_ADDRESS)
        editor.remove(KEY_IS_LOGIN)
        editor.remove(KEY_NAME)
        editor.remove(KEY_EMAIL)
        editor.remove(KEY_TOKEN)
        editor.remove(KEY_GENDER)
        editor.remove(KEY_PHONE_NUMBER)
        editor.remove(KEY_PASSWORD)
        editor.apply()
    }

    val farmerId = prefs.getString(KEY_FARMER_ID, "")
    val id = prefs.getString(KEY_USER_ID, "")
    val getToken = prefs.getString(KEY_TOKEN, "") ?: emptyString()
    val isLogin = prefs.getBoolean(KEY_IS_LOGIN, false)
    val name = prefs.getString(KEY_USER_NAME, "-")
    val email = prefs.getString(KEY_EMAIL, "-")
    val location = prefs.getString(KEY_ADDRESS, "-")
    val phoneNumber = prefs.getString(KEY_PHONE_NUMBER, "-")
    val gender = prefs.getString(KEY_GENDER, "-")
    val profilePicture = prefs.getString(KEY_PROFILE_PICTURE, "")
    val password = prefs.getString(KEY_PASSWORD, "")

}