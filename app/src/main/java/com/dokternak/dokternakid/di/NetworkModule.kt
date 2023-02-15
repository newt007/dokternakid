package com.dokternak.dokternakid.di

import com.dokternak.dokternakid.data.lib.HeaderInterceptor
import com.dokternak.dokternakid.utils.PreferenceManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/** don't forget to change it to base url form BuildConfig
 * const val baseUrl = BuildConfig.BASE_URL
 * **/
const val baseUrl = ""

val networkModule = module {

    single {
        return@single OkHttpClient.Builder()
            .addInterceptor(getHeaderInterceptor(get()))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    /**
     * declare a singleton object for retrofit service
     *
     * single { provideAuthService(get()) }
     *
     **/

}

private fun getHeaderInterceptor(preferenceManager: PreferenceManager): Interceptor {
    val headers = HashMap<String, String>()
    //define default headers here
    headers["Content-Type"] = "application/json"

    return HeaderInterceptor(headers, preferenceManager)
}

    /**
     * example to create retrofit service in order to declare a singleton object
     *
     * fun provideAuthService(retrofit: Retrofit): AuthService = retrofit.create(AuthService::class.java)
     *
    * **/