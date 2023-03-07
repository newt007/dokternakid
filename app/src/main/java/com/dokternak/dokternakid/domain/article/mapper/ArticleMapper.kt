package com.dokternak.dokternakid.domain.article.mapper

import com.dokternak.dokternakid.data.article.model.ArticleItem
import com.dokternak.dokternakid.domain.article.model.Article
import com.dokternak.dokternakid.utils.ext.emptyString

fun List<ArticleItem>.toDomain(): List<Article> {
    return this.map {
        it.toDomain()
    }
}

fun ArticleItem.toDomain(): Article {
    return Article(
        articleId = this.articleId ?: emptyString(),
        categoryId = this.categoryId ?: emptyString(),
        date = this.date ?: emptyString(),
        authorName = this.authorName ?: emptyString(),
        title = this.title ?: emptyString(),
        content = this.content ?: emptyString(),
        image = this.image ?: emptyString(),
        source = this.source ?: emptyString(),
        status = this.status ?: emptyString(),
        articleCategory = this.articleCategory ?: emptyString()
    )
}