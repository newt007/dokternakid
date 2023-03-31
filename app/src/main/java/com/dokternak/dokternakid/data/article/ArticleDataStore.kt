package com.dokternak.dokternakid.data.article

import com.dokternak.dokternakid.data.article.remote.ArticleService
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.article.mapper.toDomain
import com.dokternak.dokternakid.domain.article.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ArticleDataStore(
    private val service: ArticleService
) : ArticleRepository {

    override fun getAllArticles(): Flow<ApiResponse<List<Article>>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = service.getAllArticles()
            if (response.data != null) {
                emit(ApiResponse.Success(response.data.toDomain()))
            } else {
                emit(ApiResponse.Empty)
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

    override fun getArticleDetail(id: String): Flow<ApiResponse<Article>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = service.getArticleDetail(id)
            if (response.data != null) {
                emit(ApiResponse.Success(response.data.toDomain()))
            } else {
                emit(ApiResponse.Empty)
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

    override fun getSearchArticles(title: String): Flow<ApiResponse<List<Article>>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = service.getSearchArticles(title)
            response.data?.let { result ->
                if (result.isNotEmpty()) {
                    emit(ApiResponse.Success(result.toDomain()))
                } else {
                    emit(ApiResponse.Empty)
                }
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

}