package com.dokternak.dokternakid.di

import com.dokternak.dokternakid.presentation.article.detail.ArticleDetailViewModel
import com.dokternak.dokternakid.presentation.article.detail.ArticleViewModel
import com.dokternak.dokternakid.presentation.home.HomeViewModel
import com.dokternak.dokternakid.presentation.login.LoginViewModel
import com.dokternak.dokternakid.presentation.officer.OfficerViewModel
import com.dokternak.dokternakid.presentation.officer.detail.OfficerDetailViewModel
import com.dokternak.dokternakid.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get(), get()) }
    viewModel { OfficerViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { ArticleDetailViewModel(get()) }
    viewModel { OfficerDetailViewModel(get()) }
    viewModel { ArticleViewModel(get()) }

}