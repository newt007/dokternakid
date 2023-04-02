package com.dokternak.dokternakid.data.consultation

import com.dokternak.dokternakid.data.consultation.remote.ConsultationService
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.article.consultation.mapper.mappingToDomain
import com.dokternak.dokternakid.domain.article.consultation.mapper.toDomain
import com.dokternak.dokternakid.domain.article.consultation.model.Consultation
import com.dokternak.dokternakid.domain.article.consultation.model.ConsultationHistory
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
    ): Flow<ApiResponse<Consultation>> = flow {
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
            if (response.data != null) {
                emit(ApiResponse.Success(response.data.toDomain()))
            } else {
                emit(ApiResponse.Error(response.message))
            }
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

}