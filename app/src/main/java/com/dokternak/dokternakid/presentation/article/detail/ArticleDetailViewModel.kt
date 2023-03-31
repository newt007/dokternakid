package com.dokternak.dokternakid.presentation.article.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.article.ArticleUseCase
import com.dokternak.dokternakid.domain.article.model.Article
import kotlinx.coroutines.launch

class ArticleDetailViewModel(
    private val articleUseCase: ArticleUseCase
) : ViewModel() {

    private val _detailArticle = MutableLiveData<ApiResponse<Article>>()
    val detailArticle: LiveData<ApiResponse<Article>> get() = _detailArticle

    fun getArticleDetail(id: String) {
        viewModelScope.launch {
            articleUseCase.getArticleDetail(id).collect {
                _detailArticle.value = it
            }
        }
    }

}