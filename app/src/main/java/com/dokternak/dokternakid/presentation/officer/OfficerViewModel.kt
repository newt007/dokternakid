package com.dokternak.dokternakid.presentation.officer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.officer.OfficerUseCase
import com.dokternak.dokternakid.domain.officer.model.Officer
import kotlinx.coroutines.launch

class OfficerViewModel(
    private val officerUseCase: OfficerUseCase
): ViewModel() {

    private val _getOfficerDetail = MutableLiveData<ApiResponse<Officer>>()
    val getOfficerDetail: LiveData<ApiResponse<Officer>> by lazy { _getOfficerDetail }

    fun getOfficerDetail(id: String) {
        viewModelScope.launch {
            officerUseCase.getOfficerDetail(id)
                .collect {
                    _getOfficerDetail.value = it
                }
        }
    }

}