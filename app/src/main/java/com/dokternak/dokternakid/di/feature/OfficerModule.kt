package com.dokternak.dokternakid.di.feature

import com.dokternak.dokternakid.data.officer.OfficerDataStore
import com.dokternak.dokternakid.data.officer.OfficerRepository
import com.dokternak.dokternakid.domain.officer.OfficerInteractor
import com.dokternak.dokternakid.domain.officer.OfficerUseCase
import org.koin.dsl.module

val officerModule = module {

    factory<OfficerUseCase> { OfficerInteractor(get()) }
    factory<OfficerRepository> { OfficerDataStore(get()) }

    single { OfficerDataStore(get()) }
    single { OfficerInteractor(get()) }

}