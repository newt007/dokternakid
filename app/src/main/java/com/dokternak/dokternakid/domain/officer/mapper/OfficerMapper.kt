package com.dokternak.dokternakid.domain.officer.mapper

import com.dokternak.dokternakid.data.officer.model.OfficerItem
import com.dokternak.dokternakid.domain.officer.model.Officer
import com.dokternak.dokternakid.utils.ext.emptyString
import com.dokternak.dokternakid.utils.ext.orZero

fun List<OfficerItem>.toDomain(): List<Officer> {
    return this.map {
        it.toDomain()
    }
}

fun OfficerItem.toDomain(): Officer {
    return Officer(
        doctorId = this.doctorId.orZero(),
        doctorName = this.doctorName ?: emptyString(),
        email = this.email ?: emptyString(),
        gender = this.gender ?: emptyString(),
        address = this.address ?: emptyString(),
        place = this.place ?: emptyString(),
        phone = this.phone ?: emptyString(),
        photo = this.photo ?: emptyString(),
        certification = this.certification ?: emptyString(),
        positionId = this.positionId.orZero(),
        id = this.id ?: emptyString(),
        schedule = this.schedule ?: emptyString(),
        verified = this.verified ?: emptyString(),
        position = this.position ?: emptyString()
    )
}