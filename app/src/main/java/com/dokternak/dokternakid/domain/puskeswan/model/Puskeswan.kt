package com.dokternak.dokternakid.domain.puskeswan.model

import com.dokternak.dokternakid.utils.ext.emptyString

data class Puskeswan(
    val puskeswanId: Int = 0,
    val puskeswanName: String = emptyString(),
    val address: String = emptyString(),
    val workingArea: String = emptyString(),
    val workingTime: String = emptyString(),
    val puskeswanImage: String = emptyString(),
    val phoneNumber: String = emptyString(),
    val puskeswanMaps: String = emptyString()
)
