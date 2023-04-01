package com.dokternak.dokternakid.di

import com.dokternak.dokternakid.data.article.remote.ArticleService
import com.dokternak.dokternakid.data.category.remote.CategoryService
import com.dokternak.dokternakid.data.lib.HeaderInterceptor
import com.dokternak.dokternakid.data.membership.remote.MembershipService
import com.dokternak.dokternakid.data.officer.remote.OfficerService
import com.dokternak.dokternakid.data.puskeswan.remote.PuskeswanService
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
const val baseUrl = "https://www.dokternak.id/api/"

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

    single { provideMembershipService(get()) }
    single { provideOfficerService(get()) }
    single { provideArticleService(get()) }
    single { provideCategoryService(get()) }
    single { providePuskeswanService(get()) }

}

private fun getHeaderInterceptor(preferenceManager: PreferenceManager): Interceptor {
    val headers = HashMap<String, String>()
    //define default headers here
    headers["Content-Type"] = "application/json"

    return HeaderInterceptor(headers, preferenceManager)
}

fun provideMembershipService(retrofit: Retrofit): MembershipService =
    retrofit.create(MembershipService::class.java)

fun provideOfficerService(retrofit: Retrofit): OfficerService =
    retrofit.create(OfficerService::class.java)

fun provideArticleService(retrofit: Retrofit): ArticleService =
    retrofit.create(ArticleService::class.java)

fun provideCategoryService(retrofit: Retrofit): CategoryService =
    retrofit.create(CategoryService::class.java)

fun providePuskeswanService(retrofit: Retrofit): PuskeswanService =
    retrofit.create(PuskeswanService::class.java)
