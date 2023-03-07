package com.dokternak.dokternakid.di.feature

import com.dokternak.dokternakid.data.officer.OfficerDataStore
import com.dokternak.dokternakid.data.officer.OfficerRepository
import com.dokternak.dokternakid.domain.officer.OfficerInteractor
import com.dokternak.dokternakid.domain.officer.OfficerUseCase
import com.dokternak.dokternakid.presentation.home.HomeViewModel
import com.dokternak.dokternakid.presentation.officer.OfficerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val officerModule = module {

    factory<OfficerUseCase> { OfficerInteractor(get()) }
    factory<OfficerRepository> { OfficerDataStore(get()) }

    single { OfficerDataStore(get()) }
    single { OfficerInteractor(get()) }

    viewModel { HomeViewModel(get(), get()) }
    viewModel { OfficerViewModel(get()) }

}