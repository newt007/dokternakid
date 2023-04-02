package com.dokternak.dokternakid.domain.article.consultation

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.article.consultation.model.Consultation
import com.dokternak.dokternakid.domain.article.consultation.model.ConsultationHistory
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
    ): Flow<ApiResponse<Consultation>>

    fun getSentConsultations(): Flow<ApiResponse<List<Consultation>>>

    fun getInboxConsultations(): Flow<ApiResponse<List<ConsultationHistory>>>

}