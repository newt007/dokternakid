package com.dokternak.dokternakid.di.feature

import com.dokternak.dokternakid.data.puskeswan.PuskeswanDataStore
import com.dokternak.dokternakid.data.puskeswan.PuskeswanRepository
import com.dokternak.dokternakid.domain.puskeswan.PuskeswanInteractor
import com.dokternak.dokternakid.domain.puskeswan.PuskeswanUseCase
import org.koin.dsl.module

val puskeswanModule = module {

    factory<PuskeswanUseCase> { PuskeswanInteractor(get()) }
    factory<PuskeswanRepository> { PuskeswanDataStore(get()) }

    single { PuskeswanDataStore(get()) }
    single { PuskeswanInteractor(get()) }

}