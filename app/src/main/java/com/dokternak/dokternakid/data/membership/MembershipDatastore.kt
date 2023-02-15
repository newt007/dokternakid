package com.dokternak.dokternakid.data.membership

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.data.membership.remote.MembershipService
import com.dokternak.dokternakid.domain.membership.mapper.toDomain
import com.dokternak.dokternakid.domain.membership.model.User
import com.dokternak.dokternakid.utils.PreferenceManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MembershipDatastore(
    private val api: MembershipService,
    private val pref: PreferenceManager
): MembershipRepository {

    override fun loginUser(email: String, password: String): Flow<ApiResponse<User>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = api.loginUser(email, password)
            if (response.data != null) {
                val userData = response.data.toDomain()
                pref.apply {
                    setLoginPref(userData)
                }
                emit(ApiResponse.Success(response.data.toDomain()))
            } else {
                emit(ApiResponse.Error(response.message))
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

    override fun registerUser(
        name: String,
        email: String,
        password: String
    ): Flow<ApiResponse<User>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = api.registerUser(name, email, password)
            if (response.success == 1) {
                emit(ApiResponse.Success(response.user.toDomain()))
            } else {
                emit(ApiResponse.Error(response.message.toString()))
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }
}