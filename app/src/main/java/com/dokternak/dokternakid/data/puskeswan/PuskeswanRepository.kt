package com.dokternak.dokternakid.data.puskeswan

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.puskeswan.model.Puskeswan
import kotlinx.coroutines.flow.Flow

interface PuskeswanRepository {

    fun getPuskeswanList(): Flow<ApiResponse<List<Puskeswan>>>

    fun getPuskeswanDetail(puskeswanId: String): Flow<ApiResponse<Puskeswan>>

    fun searchPuskeswan(puskeswanName: String): Flow<ApiResponse<List<Puskeswan>>>

}