package com.dokternak.dokternakid.di

import com.dokternak.dokternakid.utils.PreferenceManager
import org.koin.dsl.module

val preferenceModule = module {

    single { PreferenceManager(get()) }

}