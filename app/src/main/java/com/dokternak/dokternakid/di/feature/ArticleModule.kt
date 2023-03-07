package com.dokternak.dokternakid.di.feature

import com.dokternak.dokternakid.data.article.ArticleDataStore
import com.dokternak.dokternakid.data.article.ArticleRepository
import com.dokternak.dokternakid.domain.article.ArticleInteractor
import com.dokternak.dokternakid.domain.article.ArticleUseCase
import org.koin.dsl.module

val articleModule = module {

    factory<ArticleUseCase> { ArticleInteractor(get()) }
    factory<ArticleRepository> { ArticleDataStore(get()) }

    single { ArticleDataStore(get()) }
    single { ArticleInteractor(get()) }


}