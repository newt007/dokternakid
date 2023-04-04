package com.dokternak.dokternakid.data.consultation

import com.dokternak.dokternakid.data.consultation.remote.ConsultationService
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.consultation.mapper.mappingToDomain
import com.dokternak.dokternakid.domain.consultation.mapper.toDomain
import com.dokternak.dokternakid.domain.consultation.model.Consultation
import com.dokternak.dokternakid.domain.consultation.model.ConsultationHistory
import com.dokternak.dokternakid.utils.PreferenceManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ConsultationDataStore(
    private val service: ConsultationService,
    private val preferenceManager: PreferenceManager
) : ConsultationRepository {

    override fun addNewConsultation(
        farmerId: String,
        doctorId: String,
        categoryId: String,
        categoriesId: String,
        animalName: String,
        complaint: String,
        sendStatus: String,
        date: String
    ): Flow<ApiResponse<String>> = flow {
        try {
            emit(ApiResponse.Loading)

            val response = service.addNewConsultation(
                farmerId,
                doctorId,
                categoryId,
                categoriesId,
                animalName,
                complaint,
                sendStatus,
                date
            )
            emit(ApiResponse.Success(response.message))
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

    override fun getSentConsultations(): Flow<ApiResponse<List<Consultation>>> = flow {
        try {
            emit(ApiResponse.Loading)

            val response = service.getSentConsultation(preferenceManager.farmerId.toString())
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

    override fun getInboxConsultations(): Flow<ApiResponse<List<ConsultationHistory>>> = flow {
        try {
            emit(ApiResponse.Loading)

            val response = service.getInboxConsultation(preferenceManager.farmerId.toString())
            response.data?.let { result ->
                if (result.isNotEmpty()) {
                    emit(ApiResponse.Success(result.mappingToDomain()))
                } else {
                    emit(ApiResponse.Empty)
                }
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

    override fun getInboxConsultationDetail(historyId: String): Flow<ApiResponse<ConsultationHistory>> =
        flow {
            try {
                emit(ApiResponse.Loading)

                val response = service.getInboxConsultationDetail(historyId)
                if (response.data != null) {
                    emit(ApiResponse.Success(response.data.mappingToDomain()))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (ex: Exception) {
                emit(ApiResponse.Error(ex.message.toString()))
            }
        }

    override fun getSentConsultationDetail(consultId: String): Flow<ApiResponse<Consultation>> =
        flow {
            try {
                emit(ApiResponse.Loading)

                val response = service.getSentConsultationDetail(consultId)
                if (response.data != null) {
                    emit(ApiResponse.Success(response.data.toDomain()))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (ex: Exception) {
                emit(ApiResponse.Error(ex.message.toString()))
            }
        }

    override fun deleteSentConsultation(consultId: String): Flow<ApiResponse<String>> = flow {
        try {
            emit(ApiResponse.Loading)

            val response = service.deleteSentConsultation(consultId)

            emit(ApiResponse.Success(response.message))
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

    override fun deleteInboxConsultation(consultId: String): Flow<ApiResponse<String>> =
        flow {
            try {
                emit(ApiResponse.Loading)

                val response = service.deleteInboxConsultation(consultId)

                emit(ApiResponse.Success(response.message))
            } catch (ex: Exception) {
                emit(ApiResponse.Error(ex.message.toString()))
            }
        }

}