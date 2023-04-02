package com.dokternak.dokternakid.presentation.puskeswan.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.puskeswan.PuskeswanUseCase
import com.dokternak.dokternakid.domain.puskeswan.model.Puskeswan
import kotlinx.coroutines.launch

class PuskeswanDetailViewModel(
    private val puskeswanUseCase: PuskeswanUseCase
): ViewModel() {

    private val _detailPuskeswan = MutableLiveData<ApiResponse<Puskeswan>>()
    val detailPuskeswan: LiveData<ApiResponse<Puskeswan>> get() = _detailPuskeswan

    fun getDetailPuskeswan(puskeswanId: String) {
        viewModelScope.launch {
            puskeswanUseCase.getPuskeswanDetail(puskeswanId).collect {
                _detailPuskeswan.value = it
            }
        }
    }

}