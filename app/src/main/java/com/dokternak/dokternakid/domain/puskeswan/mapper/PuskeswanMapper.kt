package com.dokternak.dokternakid.domain.puskeswan.mapper

import com.dokternak.dokternakid.data.puskeswan.model.PuskeswanItem
import com.dokternak.dokternakid.domain.puskeswan.model.Puskeswan
import com.dokternak.dokternakid.utils.ext.emptyString
import com.dokternak.dokternakid.utils.ext.orZero

fun PuskeswanItem.toDomain(): Puskeswan {
    return Puskeswan(
        puskeswanId = this.puskeswanId.orZero(),
        puskeswanName = this.puskeswanName ?: emptyString(),
        address = this.address ?: emptyString(),
        workingArea = this.workingArea ?: emptyString(),
        workingTime = this.workingTime ?: emptyString(),
        puskeswanImage = this.puskeswanImage ?: emptyString(),
        phoneNumber = this.phoneNumber ?: emptyString()
    )
}

fun List<PuskeswanItem>.toDomain(): List<Puskeswan> {
    return this.map {
        it.toDomain()
    }
}