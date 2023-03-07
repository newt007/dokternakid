package com.dokternak.dokternakid.data.article.model

import com.google.gson.annotations.SerializedName

data class ArticleItem(
    @SerializedName("id_artikel")
    val articleId: String?,
    @SerializedName("id_ktg")
    val categoryId: String?,
    @SerializedName("tanggal")
    val date: String?,
    @SerializedName("nama_penulis")
    val authorName: String?,
    @SerializedName("judul")
    val title: String?,
    @SerializedName("isi")
    val content: String?,
    @SerializedName("gambar")
    val image: String?,
    @SerializedName("sumber")
    val source: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("kategori_artikel")
    val articleCategory: String?
)
