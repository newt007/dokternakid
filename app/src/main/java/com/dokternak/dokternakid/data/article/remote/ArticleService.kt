package com.dokternak.dokternakid.data.article.remote

import com.dokternak.dokternakid.data.article.model.ArticleItem
import com.dokternak.dokternakid.data.lib.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleService {

    @GET("api_artikel")
    suspend fun getAllArticles(): BaseResponse<List<ArticleItem>>

    @GET("api_artikel/{id}")
    suspend fun getArticleDetail(
        @Path("id") id: String
    ): BaseResponse<ArticleItem>

    @GET("api_artikel/cari/artikel")
    suspend fun getSearchArticles(
        @Query("judul") title: String
    ): BaseResponse<List<ArticleItem>>

}