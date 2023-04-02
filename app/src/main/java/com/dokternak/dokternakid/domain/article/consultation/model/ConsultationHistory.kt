package com.dokternak.dokternakid.domain.article.consultation.model

import com.dokternak.dokternakid.utils.ext.emptyString

data class ConsultationHistory(
    val historyId: Int = 0,
    val consultationId: Int = 0,
    val responseId: Int = 0,
    val farmerId: Int = 0,
    val doctorId: Int = 0,
    val categoryId: Int = 0,
    val typeId: Int = 0,
    val positionId: String = emptyString(),
    val id: String = emptyString(),
    val responseDate: String = emptyString(),
    val response: String = emptyString(),
    val animalName: String = emptyString(),
    val complaint: String = emptyString(),
    val date: String = emptyString(),
    val sendStatus: String = emptyString(),
    val doctorName: String = emptyString(),
    val email: String = emptyString(),
    val gender: String = emptyString(),
    val address: String = emptyString(),
    val location: String = emptyString(),
    val phoneNumber: String = emptyString(),
    val photo: String = emptyString(),
    val certification: String = emptyString(),
    val workSchedule: String = emptyString(),
    val verified: String = emptyString(),
    val frontName: String = emptyString(),
    val endName: String = emptyString(),
    val farmerEmail: String = emptyString(),
    val farmerPhoneNumber: String = emptyString(),
    val farmerPicture: String = emptyString(),
    val articleCategory: String = emptyString(),
    val animalCategory: String = emptyString()
)
