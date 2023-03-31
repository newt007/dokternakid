package com.dokternak.dokternakid.data.category.model

import com.google.gson.annotations.SerializedName

data class CategoryItem(
    @SerializedName("id_ktg")
    val categoryId: Int?,
    @SerializedName("kategori_artikel")
    val categoryArticle: String?
)
