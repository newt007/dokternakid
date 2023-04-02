package com.dokternak.dokternakid.domain.article.consultation

import com.dokternak.dokternakid.data.consultation.ConsultationRepository
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.article.consultation.model.Consultation
import com.dokternak.dokternakid.domain.article.consultation.model.ConsultationHistory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class ConsultationInteractor(
    private val repository: ConsultationRepository
) : ConsultationUseCase {

    override fun addNewConsultation(
        farmerId: String,
        doctorId: String,
        categoryId: String,
        categoriesId: String,
        animalName: String,
        complaint: String,
        sendStatus: String,
        date: String
    ): Flow<ApiResponse<Consultation>> {
        return repository.addNewConsultation(
            farmerId,
            doctorId,
            categoryId,
            categoriesId,
            animalName,
            complaint,
            sendStatus,
            date
        ).flowOn(Dispatchers.IO)
    }

    override fun getSentConsultations(): Flow<ApiResponse<List<Consultation>>> {
        return repository.getSentConsultations()
            .flowOn(Dispatchers.IO)
    }

    override fun getInboxConsultations(): Flow<ApiResponse<List<ConsultationHistory>>> {
        return repository.getInboxConsultations()
            .flowOn(Dispatchers.IO)
    }

}