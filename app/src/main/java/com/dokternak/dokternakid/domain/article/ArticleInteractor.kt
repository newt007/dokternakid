package com.dokternak.dokternakid.domain.article

import com.dokternak.dokternakid.data.article.ArticleRepository
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.article.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class ArticleInteractor(
    private val repository: ArticleRepository
): ArticleUseCase {

    override fun getAllArticles(): Flow<ApiResponse<List<Article>>> {
        return repository.getAllArticles()
            .flowOn(Dispatchers.IO)
    }

    override fun getArticleDetail(id: String): Flow<ApiResponse<Article>> {
        return repository.getArticleDetail(id)
            .flowOn(Dispatchers.IO)
    }

    override fun getSearchArticles(title: String): Flow<ApiResponse<List<Article>>> {
        return repository.getSearchArticles(title)
            .flowOn(Dispatchers.IO)
    }

}