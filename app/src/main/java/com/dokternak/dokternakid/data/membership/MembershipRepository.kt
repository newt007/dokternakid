package com.dokternak.dokternakid.data.membership

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.membership.model.User
import kotlinx.coroutines.flow.Flow

interface MembershipRepository {

    fun loginUser(email: String, password: String): Flow<ApiResponse<User>>

    fun registerUser(
        name: String,
        email: String,
        password: String
    ): Flow<ApiResponse<User>>

}