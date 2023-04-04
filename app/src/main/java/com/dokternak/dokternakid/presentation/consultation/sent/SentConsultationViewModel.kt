package com.dokternak.dokternakid.presentation.consultation.sent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.consultation.ConsultationUseCase
import com.dokternak.dokternakid.domain.consultation.model.Consultation
import kotlinx.coroutines.launch

class SentConsultationViewModel(
    private val consultationUseCase: ConsultationUseCase
): ViewModel() {

    private val _sentConsultationResult = MutableLiveData<ApiResponse<List<Consultation>>>()
    val sentConsultationResult: LiveData<ApiResponse<List<Consultation>>> get() = _sentConsultationResult

    fun getSentConsultations() {
        viewModelScope.launch {
            consultationUseCase.getSentConsultations().collect {
                _sentConsultationResult.value = it
            }
        }
    }

}