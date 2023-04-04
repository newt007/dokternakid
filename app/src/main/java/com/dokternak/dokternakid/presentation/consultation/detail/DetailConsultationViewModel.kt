package com.dokternak.dokternakid.presentation.consultation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.consultation.ConsultationUseCase
import com.dokternak.dokternakid.domain.consultation.model.Consultation
import com.dokternak.dokternakid.domain.consultation.model.ConsultationHistory
import kotlinx.coroutines.launch

class DetailConsultationViewModel(
    private val consultationUseCase: ConsultationUseCase
) : ViewModel() {

    private val _detailSentConsultation = MutableLiveData<ApiResponse<Consultation>>()
    val detailSentConsultation: LiveData<ApiResponse<Consultation>> get() = _detailSentConsultation

    private val _detailInboxConsultation = MutableLiveData<ApiResponse<ConsultationHistory>>()
    val detailInboxConsultation: LiveData<ApiResponse<ConsultationHistory>> get() = _detailInboxConsultation

    private val _deleteSentConsultationResult = MutableLiveData<ApiResponse<String>>()
    val deleteSentConsultationResult: LiveData<ApiResponse<String>> get() = _deleteSentConsultationResult

    private val _deleteInboxConsultationResult = MutableLiveData<ApiResponse<String>>()
    val deleteInboxConsultationResult: LiveData<ApiResponse<String>> get() = _deleteInboxConsultationResult

    fun getDetailSentConsultation(consultId: String) {
        viewModelScope.launch {
            consultationUseCase.getSentConsultationDetail(consultId).collect {
                _detailSentConsultation.value = it
            }
        }
    }

    fun getDetailInboxConsultation(historyId: String) {
        viewModelScope.launch {
            consultationUseCase.getInboxConsultationDetail(historyId).collect {
                _detailInboxConsultation.value = it
            }
        }
    }

    fun deleteSentConsultation(consultId: String) {
        viewModelScope.launch {
            consultationUseCase.deleteSentConsultation(consultId).collect {
                _deleteSentConsultationResult.value = it
            }
        }
    }

    fun deleteInboxConsultation(consultId: String) {
        viewModelScope.launch {
            consultationUseCase.deleteInboxConsultation(consultId).collect {
                _deleteInboxConsultationResult.value = it
            }
        }
    }

}