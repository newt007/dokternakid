package com.dokternak.dokternakid.data.lib

import com.dokternak.dokternakid.utils.AuthConstant
import com.dokternak.dokternakid.utils.ConstVal.KEY_TOKEN
import com.dokternak.dokternakid.utils.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor(
    private val requestHeaders: HashMap<String, String>,
    private val preferenceManager: PreferenceManager
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val path = chain.request().url.toString()
        print("<<<<<<<<< $path")
        if (path.contains("logout")) {
            mapRequestHeaders()
            preferenceManager.clearPreferenceByKey(KEY_TOKEN)
            print("<<<<<<<<< $requestHeaders")
        } else {
            mapRequestHeaders()
        }

        val request = mapHeaders(chain)

        return chain.proceed(request)
    }

    private fun mapRequestHeaders() {
        val token = preferenceManager.getToken
        requestHeaders[AuthConstant.AUTHORIZATION] = "Bearer $token"
    }

    private fun mapHeaders(chain: Interceptor.Chain): Request {
        val original = chain.request()

        val requestBuilder = original.newBuilder()

        for ((key, value) in requestHeaders) {
            requestBuilder.addHeader(key, value)
        }
        return requestBuilder.build()
    }

}