package com.dokternak.dokternakid.domain.consultation

import com.dokternak.dokternakid.data.consultation.ConsultationRepository
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.consultation.model.Consultation
import com.dokternak.dokternakid.domain.consultation.model.ConsultationHistory
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
    ): Flow<ApiResponse<String>> {
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

    override fun getInboxConsultationDetail(historyId: String): Flow<ApiResponse<ConsultationHistory>> {
        return repository.getInboxConsultationDetail(historyId)
            .flowOn(Dispatchers.IO)
    }

    override fun getSentConsultationDetail(consultId: String): Flow<ApiResponse<Consultation>> {
        return repository.getSentConsultationDetail(consultId)
            .flowOn(Dispatchers.IO)
    }

    override fun deleteSentConsultation(consultId: String): Flow<ApiResponse<String>> {
        return repository.deleteSentConsultation(consultId)
            .flowOn(Dispatchers.IO)
    }

    override fun deleteInboxConsultation(consultId: String): Flow<ApiResponse<String>> {
        return repository.deleteInboxConsultation(consultId)
            .flowOn(Dispatchers.IO)
    }

}