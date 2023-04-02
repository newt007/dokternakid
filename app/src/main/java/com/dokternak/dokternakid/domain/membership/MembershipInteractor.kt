package com.dokternak.dokternakid.domain.membership

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.data.membership.MembershipRepository
import com.dokternak.dokternakid.domain.membership.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class MembershipInteractor(
    private val repository: MembershipRepository
) : MembershipUseCase {

    override fun loginUser(email: String, password: String): Flow<ApiResponse<User>> {
        return repository.loginUser(email, password)
            .flowOn(Dispatchers.IO)
    }

    override fun registerUser(
        name: String,
        email: String,
        password: String
    ): Flow<ApiResponse<User>> {
        return repository.registerUser(name, email, password)
            .flowOn(Dispatchers.IO)
    }

    override fun editUserProfile(
        id: Int,
        name: String,
        password: String,
        email: String,
        phoneNumber: String,
        gender: String,
        address: String,
        profilePicture: String
    ): Flow<ApiResponse<User>> {
        return repository.editUserProfile(
            id,
            name,
            password,
            email,
            phoneNumber,
            gender,
            address,
            profilePicture
        ).flowOn(Dispatchers.IO)
    }

}