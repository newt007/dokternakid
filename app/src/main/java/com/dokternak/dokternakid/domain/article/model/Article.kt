package com.dokternak.dokternakid.domain.article.model

import com.dokternak.dokternakid.utils.ext.emptyString

data class Article(
    val articleId: String = emptyString(),
    val categoryId: String = emptyString(),
    val date: String = emptyString(),
    val authorName: String = emptyString(),
    val title: String = emptyString(),
    val content: String = emptyString(),
    val image: String = emptyString(),
    val source: String = emptyString(),
    val status: String = emptyString(),
    val articleCategory: String = emptyString()
)
