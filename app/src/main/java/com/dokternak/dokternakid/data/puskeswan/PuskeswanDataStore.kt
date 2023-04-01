package com.dokternak.dokternakid.data.puskeswan

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.data.puskeswan.remote.PuskeswanService
import com.dokternak.dokternakid.domain.puskeswan.mapper.toDomain
import com.dokternak.dokternakid.domain.puskeswan.model.Puskeswan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PuskeswanDataStore(
    private val service: PuskeswanService
): PuskeswanRepository {

    override fun getPuskeswanList(): Flow<ApiResponse<List<Puskeswan>>> = flow {
        try {
            emit(ApiResponse.Loading)

            val response = service.getPuskeswanList()
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

    override fun getPuskeswanDetail(puskeswanId: String): Flow<ApiResponse<Puskeswan>> = flow {
        try {
            emit(ApiResponse.Loading)

            val response = service.getPuskeswanDetail(puskeswanId)
            if (response.data != null) {
                emit(ApiResponse.Success(response.data.toDomain()))
            } else {
                emit(ApiResponse.Empty)
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

    override fun searchPuskeswan(puskeswanName: String): Flow<ApiResponse<List<Puskeswan>>> = flow {
        try {
            emit(ApiResponse.Loading)

            val response = service.searchPuskeswan(puskeswanName)
            response.data?.let {
                if (it.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data.toDomain()))
                } else {
                    emit(ApiResponse.Empty)
                }
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

}