package com.dokternak.dokternakid.presentation.consultation.inbox

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.consultation.ConsultationUseCase
import com.dokternak.dokternakid.domain.consultation.model.ConsultationHistory
import kotlinx.coroutines.launch

class InboxConsultationViewModel(
    private val consultationUseCase: ConsultationUseCase
) : ViewModel() {

    private val _inboxConsultationResult = MutableLiveData<ApiResponse<List<ConsultationHistory>>>()
    val inboxConsultationResult: LiveData<ApiResponse<List<ConsultationHistory>>> get() = _inboxConsultationResult

    fun getInboxConsultation() {
        viewModelScope.launch {
            consultationUseCase.getInboxConsultations().collect {
                _inboxConsultationResult.value = it
            }
        }
    }

}