package com.dokternak.dokternakid.di.feature

import com.dokternak.dokternakid.data.consultation.ConsultationDataStore
import com.dokternak.dokternakid.data.consultation.ConsultationRepository
import com.dokternak.dokternakid.domain.consultation.ConsultationInteractor
import com.dokternak.dokternakid.domain.consultation.ConsultationUseCase
import org.koin.dsl.module

val consultationModule = module {

    factory<ConsultationUseCase> { ConsultationInteractor(get()) }
    factory<ConsultationRepository> { ConsultationDataStore(get(), get()) }

    single { ConsultationDataStore(get(), get()) }
    single { ConsultationInteractor(get()) }

}