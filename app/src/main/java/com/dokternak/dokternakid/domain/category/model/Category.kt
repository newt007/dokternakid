package com.dokternak.dokternakid.domain.category.model

import com.dokternak.dokternakid.utils.ext.emptyString

data class Category(
    val categoryId: Int = 0,
    val categoryArticle: String = emptyString()
)
