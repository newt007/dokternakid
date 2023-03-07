package com.dokternak.dokternakid.domain.officer.model

import com.dokternak.dokternakid.utils.ext.emptyString

data class Officer(
    val doctorId: Int = 0,
    val doctorName: String = emptyString(),
    val email: String = emptyString(),
    val gender: String = emptyString(),
    val address: String = emptyString(),
    val place: String = emptyString(),
    val phone: String = emptyString(),
    val photo: String = emptyString(),
    val certification: String = emptyString(),
    val positionId: Int = 0,
    val id: String = emptyString(),
    val schedule: String = emptyString(),
    val verified: String = emptyString(),
    val position: String = emptyString()
)
