package com.dokternak.dokternakid.presentation.puskeswan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.puskeswan.PuskeswanUseCase
import com.dokternak.dokternakid.domain.puskeswan.model.Puskeswan
import kotlinx.coroutines.launch

class PuskeswanViewModel(
    private val puskeswanUseCase: PuskeswanUseCase
): ViewModel() {

    private val _getPuskeswanList = MutableLiveData<ApiResponse<List<Puskeswan>>>()
    val getPuskeswanList: LiveData<ApiResponse<List<Puskeswan>>> get() = _getPuskeswanList

    fun getAllPuskeswan() {
        viewModelScope.launch {
            puskeswanUseCase.getPuskeswanList().collect {
                _getPuskeswanList.value = it
            }
        }
    }

}