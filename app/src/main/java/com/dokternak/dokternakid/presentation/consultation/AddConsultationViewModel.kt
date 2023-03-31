package com.dokternak.dokternakid.presentation.consultation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.category.CategoryUseCase
import com.dokternak.dokternakid.domain.category.model.Category
import kotlinx.coroutines.launch

class AddConsultationViewModel(
    private val categoryUseCase: CategoryUseCase
): ViewModel() {

    private val _categoryResults = MutableLiveData<ApiResponse<List<Category>>>()
    val categoryResults: LiveData<ApiResponse<List<Category>>> get() = _categoryResults

    fun getCategories() {
        viewModelScope.launch {
            categoryUseCase.getAllCategories().collect {
                _categoryResults.value = it
            }
        }
    }

}