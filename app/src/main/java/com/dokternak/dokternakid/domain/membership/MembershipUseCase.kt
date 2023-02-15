package com.dokternak.dokternakid.domain.membership

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.membership.model.User
import kotlinx.coroutines.flow.Flow

interface MembershipUseCase {

    fun loginUser(
        email: String,
        password: String
    ): Flow<ApiResponse<User>>

    fun registerUser(
        name: String,
        email: String,
        password: String
    ): Flow<ApiResponse<User>>

}