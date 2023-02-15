package com.dokternak.dokternakid.base

import android.app.Application
import com.dokternak.dokternakid.di.feature.membershipModule
import com.dokternak.dokternakid.di.networkModule
import com.dokternak.dokternakid.di.preferenceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    membershipModule,
                    networkModule,
                    preferenceModule
                )
            )
        }
    }

}