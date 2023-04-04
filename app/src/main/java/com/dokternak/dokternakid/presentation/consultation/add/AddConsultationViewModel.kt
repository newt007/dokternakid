package com.dokternak.dokternakid.presentation.consultation.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.category.CategoryUseCase
import com.dokternak.dokternakid.domain.category.model.Category
import com.dokternak.dokternakid.domain.consultation.ConsultationUseCase
import kotlinx.coroutines.launch

class AddConsultationViewModel(
    private val categoryUseCase: CategoryUseCase,
    private val consultationUseCase: ConsultationUseCase
) : ViewModel() {

    private val _categoryResults = MutableLiveData<ApiResponse<List<Category>>>()
    val categoryResults: LiveData<ApiResponse<List<Category>>> get() = _categoryResults

    private val _addNewConsultationResult = MutableLiveData<ApiResponse<String>>()
    val addNewConsultationResult: LiveData<ApiResponse<String>> get() = _addNewConsultationResult

    fun getCategories() {
        viewModelScope.launch {
            categoryUseCase.getAllCategories().collect {
                _categoryResults.value = it
            }
        }
    }

    fun addNewConsultation(
        farmerId: String,
        doctorId: String,
        categoryId: String,
        animalType: String,
        animalName: String,
        complaint: String,
        sendStatus: String,
        date: String
    ) {
        viewModelScope.launch {
            consultationUseCase.addNewConsultation(
                farmerId,
                doctorId,
                categoryId,
                animalType,
                animalName,
                complaint,
                sendStatus,
                date
            ).collect {
                _addNewConsultationResult.value = it
            }
        }
    }

}