package com.dokternak.dokternakid.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.membership.MembershipUseCase
import com.dokternak.dokternakid.domain.membership.model.User
import kotlinx.coroutines.launch

class LoginViewModel(
    private val useCase: MembershipUseCase
) : ViewModel() {

    private val _loginResult = MutableLiveData<ApiResponse<User>>()
    val loginResult: LiveData<ApiResponse<User>> by lazy { _loginResult }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            useCase.loginUser(email, password)
                .collect {
                    _loginResult.value = it
                }
        }
    }

}