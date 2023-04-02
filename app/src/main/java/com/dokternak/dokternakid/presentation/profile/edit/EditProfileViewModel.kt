package com.dokternak.dokternakid.presentation.profile.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.membership.MembershipUseCase
import com.dokternak.dokternakid.domain.membership.model.User
import kotlinx.coroutines.launch

class EditProfileViewModel(
    private val membershipUseCase: MembershipUseCase
) : ViewModel() {

    private val _editProfileResult = MutableLiveData<ApiResponse<User>>()
    val profileResult: LiveData<ApiResponse<User>> get() = _editProfileResult

    fun editProfile(
        id: Int,
        name: String,
        password: String,
        email: String,
        phoneNumber: String,
        gender: String,
        address: String,
        profilePicture: String
    ) {
        viewModelScope.launch {
            membershipUseCase.editUserProfile(
                id,
                name,
                password,
                email,
                phoneNumber,
                gender,
                address,
                profilePicture
            ).collect {
                _editProfileResult.value = it
            }
        }
    }

}