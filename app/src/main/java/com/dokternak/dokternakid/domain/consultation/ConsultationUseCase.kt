package com.dokternak.dokternakid.domain.consultation

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.consultation.model.Consultation
import com.dokternak.dokternakid.domain.consultation.model.ConsultationHistory
import kotlinx.coroutines.flow.Flow

interface ConsultationUseCase {

    fun addNewConsultation(
        farmerId: String,
        doctorId: String,
        categoryId: String,
        categoriesId: String,
        animalName: String,
        complaint: String,
        sendStatus: String,
        date: String
    ): Flow<ApiResponse<String>>

    fun getSentConsultations(): Flow<ApiResponse<List<Consultation>>>

    fun getInboxConsultations(): Flow<ApiResponse<List<ConsultationHistory>>>

    fun getInboxConsultationDetail(historyId: String): Flow<ApiResponse<ConsultationHistory>>

    fun getSentConsultationDetail(consultId: String): Flow<ApiResponse<Consultation>>

    fun deleteSentConsultation(consultId: String): Flow<ApiResponse<String>>

    fun deleteInboxConsultation(consultId: String): Flow<ApiResponse<String>>

}