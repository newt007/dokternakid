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

    private val _searchOfficerResult = MutableLiveData<ApiResponse<List<Officer>>>()
    val searchOfficerResult: LiveData<ApiResponse<List<Officer>>> by lazy { _searchOfficerResult }

    init {
        getSearchOfficers("")
    }

    fun getSearchOfficers(officerName: String) {
        viewModelScope.launch {
            officerUseCase.getSearchOfficers(officerName)
                .collect {
                    _searchOfficerResult.value = it
                }
        }
    }

}