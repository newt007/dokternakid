package com.dokternak.dokternakid.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.membership.MembershipUseCase
import com.dokternak.dokternakid.domain.membership.model.User
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val useCase: MembershipUseCase
) : ViewModel() {

    private val _registerResult = MutableLiveData<ApiResponse<User>>()
    val registerResult: LiveData<ApiResponse<User>> by lazy { _registerResult }

    fun registerUser(
        name: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            useCase.registerUser(name, email, password)
                .collect {
                    _registerResult.value = it
                }
        }
    }

}