package com.dokternak.dokternakid.domain.puskeswan

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.data.puskeswan.PuskeswanRepository
import com.dokternak.dokternakid.domain.puskeswan.model.Puskeswan
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class PuskeswanInteractor(
    private val repository: PuskeswanRepository
): PuskeswanUseCase {

    override fun getPuskeswanList(): Flow<ApiResponse<List<Puskeswan>>> {
        return repository.getPuskeswanList()
            .flowOn(Dispatchers.IO)
    }

    override fun getPuskeswanDetail(puskeswanId: String): Flow<ApiResponse<Puskeswan>> {
        return repository.getPuskeswanDetail(puskeswanId)
            .flowOn(Dispatchers.IO)
    }

    override fun searchPuskeswan(puskeswanName: String): Flow<ApiResponse<List<Puskeswan>>> {
        return repository.searchPuskeswan(puskeswanName)
            .flowOn(Dispatchers.IO)
    }

}