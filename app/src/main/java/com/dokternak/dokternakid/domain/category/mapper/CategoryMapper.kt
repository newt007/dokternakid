package com.dokternak.dokternakid.domain.category.mapper

import com.dokternak.dokternakid.data.category.model.CategoryItem
import com.dokternak.dokternakid.domain.category.model.Category
import com.dokternak.dokternakid.utils.ext.emptyString
import com.dokternak.dokternakid.utils.ext.orZero

fun CategoryItem.toDomain(): Category {
    return Category(
        categoryId = this.categoryId.orZero(),
        categoryArticle = this.categoryArticle ?: emptyString()
    )
}

fun List<CategoryItem>.toDomain(): List<Category> {
    return this.map {
        it.toDomain()
    }
}