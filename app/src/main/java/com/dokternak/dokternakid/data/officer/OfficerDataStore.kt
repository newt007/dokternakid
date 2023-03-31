package com.dokternak.dokternakid.data.officer

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.data.officer.remote.OfficerService
import com.dokternak.dokternakid.domain.officer.mapper.toDomain
import com.dokternak.dokternakid.domain.officer.model.Officer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OfficerDataStore(
    private val api: OfficerService
): OfficerRepository {

    override fun getAllOfficers(): Flow<ApiResponse<List<Officer>>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = api.getAllOffices()
            if (response.data != null) {
                emit(ApiResponse.Success(response.data.toDomain()))
            } else {
                emit(ApiResponse.Empty)
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

    override fun getOfficerDetail(id: String): Flow<ApiResponse<Officer>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = api.getOfficerDetail(id)
            if (response.data != null) {
                emit(ApiResponse.Success(response.data.toDomain()))
            } else {
                emit(ApiResponse.Empty)
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

    override fun getSearchOfficers(officerName: String): Flow<ApiResponse<List<Officer>>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = api.getSearchOfficers(officerName)
            response.data?.let { result ->
                if (result.isNotEmpty()) {
                    emit(ApiResponse.Success(result.toDomain()))
                } else {
                    emit(ApiResponse.Empty)
                }
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }


}