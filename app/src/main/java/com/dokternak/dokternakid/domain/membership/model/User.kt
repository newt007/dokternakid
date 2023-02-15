package com.dokternak.dokternakid.domain.membership.model

import com.dokternak.dokternakid.utils.ext.emptyString

data class User(
    val id: String = emptyString(),
    val name: String = emptyString(),
    val email: String = emptyString(),
    val isAdmin: String = emptyString(),
    val farmerId: Long = 0L,
    val frontName: String = emptyString(),
    val endName: String = emptyString(),
    val farmerEmail: String = emptyString(),
    val phoneNumber: String = emptyString(),
    val gender: String = emptyString(),
    val address: String = emptyString(),
    val farmPicture: String = emptyString()
)
