package com.dokternak.dokternakid.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.article.ArticleUseCase
import com.dokternak.dokternakid.domain.article.model.Article
import com.dokternak.dokternakid.domain.officer.OfficerUseCase
import com.dokternak.dokternakid.domain.officer.model.Officer
import kotlinx.coroutines.launch

class HomeViewModel(
    private val officerUseCase: OfficerUseCase,
    private val articleUseCase: ArticleUseCase
): ViewModel() {

    private val _getAllOfficers = MutableLiveData<ApiResponse<List<Officer>>>()
    val getAllOfficers: LiveData<ApiResponse<List<Officer>>> by lazy { _getAllOfficers }

    private val _getAllArticles = MutableLiveData<ApiResponse<List<Article>>>()
    val getAllArticles: LiveData<ApiResponse<List<Article>>> by lazy { _getAllArticles }

    fun getAllOfficers() {
        viewModelScope.launch {
            officerUseCase.getAllOfficers()
                .collect {
                    _getAllOfficers.value = it
                }
        }
    }

    fun getAllArticles() {
        viewModelScope.launch {
            articleUseCase.getAllArticles()
                .collect {
                    _getAllArticles.value = it
                }
        }
    }

}