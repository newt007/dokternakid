package com.dokternak.dokternakid.presentation.article.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.article.ArticleUseCase
import com.dokternak.dokternakid.domain.article.model.Article
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val articleUseCase: ArticleUseCase
): ViewModel() {

    private val _searchArticlesResult = MutableLiveData<ApiResponse<List<Article>>>()
    val searchArticlesResult: LiveData<ApiResponse<List<Article>>> get() = _searchArticlesResult

    fun searchArticle(title: String) {
        viewModelScope.launch {
            articleUseCase.getSearchArticles(title).collect {
                _searchArticlesResult.value = it
            }
        }
    }

}