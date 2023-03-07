package com.dokternak.dokternakid.data.article.remote

import com.dokternak.dokternakid.data.article.model.ArticleItem
import com.dokternak.dokternakid.data.lib.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleService {

    @GET("api_artikel")
    suspend fun getAllArticles(): BaseResponse<List<ArticleItem>>

    @GET("api_artikel/{id}")
    suspend fun getArticleDetail(
        @Path("id") id: String
    ): BaseResponse<ArticleItem>

}