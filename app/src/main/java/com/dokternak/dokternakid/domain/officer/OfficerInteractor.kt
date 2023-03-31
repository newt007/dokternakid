package com.dokternak.dokternakid.domain.officer

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.data.officer.OfficerRepository
import com.dokternak.dokternakid.domain.officer.model.Officer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class OfficerInteractor(
    private val repository: OfficerRepository
): OfficerUseCase {

    override fun getAllOfficers(): Flow<ApiResponse<List<Officer>>> {
        return repository.getAllOfficers()
            .flowOn(Dispatchers.IO)
    }

    override fun getOfficerDetail(id: String): Flow<ApiResponse<Officer>> {
        return repository.getOfficerDetail(id)
            .flowOn(Dispatchers.IO)
    }

    override fun getSearchOfficers(officerName: String): Flow<ApiResponse<List<Officer>>> {
        return repository.getSearchOfficers(officerName)
            .flowOn(Dispatchers.IO)
    }

}