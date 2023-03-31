package com.dokternak.dokternakid.di.feature

import com.dokternak.dokternakid.data.category.CategoryDataStore
import com.dokternak.dokternakid.data.category.CategoryRepository
import com.dokternak.dokternakid.domain.category.CategoryInteractor
import com.dokternak.dokternakid.domain.category.CategoryUseCase
import org.koin.dsl.module

val categoryModule = module {

    factory<CategoryUseCase> { CategoryInteractor(get()) }
    factory<CategoryRepository> { CategoryDataStore(get()) }

    single { CategoryDataStore(get()) }
    single { CategoryInteractor(get()) }

}