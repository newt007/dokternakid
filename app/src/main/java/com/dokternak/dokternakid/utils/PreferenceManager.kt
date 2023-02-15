package com.dokternak.dokternakid.utils

import android.content.Context
import android.content.SharedPreferences
import com.dokternak.dokternakid.utils.ConstVal
import com.dokternak.dokternakid.utils.ConstVal.KEY_ADDRESS
import com.dokternak.dokternakid.utils.ConstVal.KEY_EMAIL
import com.dokternak.dokternakid.utils.ConstVal.KEY_IS_LOGIN
import com.dokternak.dokternakid.utils.ConstVal.KEY_NAME
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

    fun clearAllPreferences() {
        editor.remove(KEY_USER_ID)
        editor.remove(KEY_USER_NAME)
        editor.remove(KEY_ADDRESS)
        editor.remove(KEY_IS_LOGIN)
        editor.remove(KEY_NAME)
        editor.remove(KEY_EMAIL)
        editor.remove(KEY_TOKEN)
        editor.apply()
    }

    val getToken = prefs.getString(KEY_TOKEN, "") ?: emptyString()

}