package com.dokternak.dokternakid.data.category.remote

import com.dokternak.dokternakid.data.category.model.CategoryItem
import com.dokternak.dokternakid.data.lib.BaseResponse
import retrofit2.http.GET

interface CategoryService {

    @GET("api_kategori")
    suspend fun getAnimalCategory(): BaseResponse<List<CategoryItem>>

}