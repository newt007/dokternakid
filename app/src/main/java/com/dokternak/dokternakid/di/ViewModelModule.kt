package com.dokternak.dokternakid.di

import com.dokternak.dokternakid.presentation.article.detail.ArticleDetailViewModel
import com.dokternak.dokternakid.presentation.article.detail.ArticleViewModel
import com.dokternak.dokternakid.presentation.consultation.add.AddConsultationViewModel
import com.dokternak.dokternakid.presentation.consultation.detail.DetailConsultationViewModel
import com.dokternak.dokternakid.presentation.consultation.inbox.InboxConsultationViewModel
import com.dokternak.dokternakid.presentation.consultation.sent.SentConsultationViewModel
import com.dokternak.dokternakid.presentation.home.HomeViewModel
import com.dokternak.dokternakid.presentation.login.LoginViewModel
import com.dokternak.dokternakid.presentation.officer.OfficerViewModel
import com.dokternak.dokternakid.presentation.officer.detail.OfficerDetailViewModel
import com.dokternak.dokternakid.presentation.officer.search.SearchOfficerViewModel
import com.dokternak.dokternakid.presentation.profile.edit.EditProfileViewModel
import com.dokternak.dokternakid.presentation.puskeswan.PuskeswanViewModel
import com.dokternak.dokternakid.presentation.puskeswan.detail.PuskeswanDetailViewModel
import com.dokternak.dokternakid.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get(), get()) }

    viewModel { OfficerViewModel(get()) }
    viewModel { OfficerDetailViewModel(get()) }
    viewModel { SearchOfficerViewModel(get()) }

    viewModel { ArticleDetailViewModel(get()) }
    viewModel { ArticleViewModel(get()) }

    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { EditProfileViewModel(get()) }

    viewModel { AddConsultationViewModel(get(), get()) }
    viewModel { SentConsultationViewModel(get()) }
    viewModel { InboxConsultationViewModel(get()) }
    viewModel { DetailConsultationViewModel(get()) }

    viewModel { PuskeswanViewModel(get()) }
    viewModel { PuskeswanDetailViewModel(get()) }

}