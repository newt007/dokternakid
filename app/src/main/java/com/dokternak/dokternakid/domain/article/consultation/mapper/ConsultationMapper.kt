package com.dokternak.dokternakid.domain.article.consultation.mapper

import com.dokternak.dokternakid.data.consultation.model.ConsultationHistoryItem
import com.dokternak.dokternakid.data.consultation.model.ConsultationItem
import com.dokternak.dokternakid.domain.article.consultation.model.Consultation
import com.dokternak.dokternakid.domain.article.consultation.model.ConsultationHistory
import com.dokternak.dokternakid.utils.ext.emptyString
import com.dokternak.dokternakid.utils.ext.orZero

fun ConsultationItem.toDomain(): Consultation {
    return Consultation(
        consultationId = this.consultationId.orZero(),
        farmerId = this.farmerId.orZero(),
        doctorId = this.doctorId.orZero(),
        categoryId = this.categoryId.orZero(),
        positionId = this.positionId ?: emptyString(),
        id = this.id ?: emptyString(),
        animalName = this.animalName ?: emptyString(),
        complaint = this.complaint ?: emptyString(),
        date = this.date ?: emptyString(),
        sendStatus = this.sendStatus ?: emptyString(),
        doctorName = this.doctorName ?: emptyString (),
        email = this.email ?: emptyString(),
        gender = this.gender ?: emptyString(),
        address = this.address ?: emptyString(),
        location = this.location ?: emptyString(),
        phoneNumber = this.phoneNumber ?: emptyString(),
        photo  = this.photo ?: emptyString(),
        certification = this.certification ?: emptyString(),
        workSchedule = this.workSchedule ?: emptyString(),
        verified = this.verified ?: emptyString(),
        frontName = this.frontName ?: emptyString(),
        endName = this.endName ?: emptyString(),
        farmerEmail = this.farmerEmail ?: emptyString(),
        farmerPhoneNumber = this.farmerPhoneNumber ?: emptyString(),
        farmerPicture = this.farmerPicture ?: emptyString(),
        articleCategory = this.articleCategory ?: emptyString(),
        animalCategory = this.animalCategory ?: emptyString()
    )
}

fun ConsultationHistoryItem.mappingToDomain(): ConsultationHistory {
    return ConsultationHistory(
        historyId = this.historyId.orZero(),
        consultationId = this.consultationId.orZero(),
        responseId = this.responseId.orZero(),
        farmerId = this.farmerId.orZero(),
        doctorId = this.doctorId.orZero(),
        categoryId = this.categoryId.orZero(),
        typeId = this.typeId.orZero(),
        positionId = this.positionId ?: emptyString(),
        id = this.id ?: emptyString(),
        responseDate = this.responseDate ?: emptyString(),
        response = this.response ?: emptyString(),
        animalName = this.animalName ?: emptyString(),
        complaint = this.complaint ?: emptyString(),
        date = this.date ?: emptyString(),
        sendStatus = this.sendStatus ?: emptyString(),
        doctorName = this.doctorName ?: emptyString (),
        email = this.email ?: emptyString(),
        gender = this.gender ?: emptyString(),
        address = this.address ?: emptyString(),
        location = this.location ?: emptyString(),
        phoneNumber = this.phoneNumber ?: emptyString(),
        photo  = this.photo ?: emptyString(),
        certification = this.certification ?: emptyString(),
        workSchedule = this.workSchedule ?: emptyString(),
        verified = this.verified ?: emptyString(),
        frontName = this.frontName ?: emptyString(),
        endName = this.endName ?: emptyString(),
        farmerEmail = this.farmerEmail ?: emptyString(),
        farmerPhoneNumber = this.farmerPhoneNumber ?: emptyString(),
        farmerPicture = this.farmerPicture ?: emptyString(),
        articleCategory = this.articleCategory ?: emptyString(),
        animalCategory = this.animalCategory ?: emptyString()
    )
}

fun List<ConsultationItem>.toDomain(): List<Consultation> {
    return this.map {
        it.toDomain()
    }
}

fun List<ConsultationHistoryItem>.mappingToDomain(): List<ConsultationHistory> {
    return this.map {
        it.mappingToDomain()
    }
}