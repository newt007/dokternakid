package com.dokternak.dokternakid.domain.article

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.article.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleUseCase {

    fun getAllArticles(): Flow<ApiResponse<List<Article>>>

    fun getArticleDetail(id: String): Flow<ApiResponse<Article>>

}