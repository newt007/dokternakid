package com.dokternak.dokternakid.presentation.officer.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.officer.OfficerUseCase
import com.dokternak.dokternakid.domain.officer.model.Officer
import kotlinx.coroutines.launch

class SearchOfficerViewModel(
    private val officerUseCase: OfficerUseCase
): ViewModel() {

    private val _searchOfficerResult = MutableLiveData<ApiResponse<List<Officer>>>()
    val searchOfficerResult: LiveData<ApiResponse<List<Officer>>> get() = _searchOfficerResult

    fun searchOfficer(query: String) {
        viewModelScope.launch {
            officerUseCase.getSearchOfficers(query).collect {
                _searchOfficerResult.value = it
            }
        }
    }

}