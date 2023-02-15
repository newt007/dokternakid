package com.dokternak.dokternakid.domain.membership.mapper

import com.dokternak.dokternakid.data.membership.model.UserItem
import com.dokternak.dokternakid.domain.membership.model.User
import com.dokternak.dokternakid.utils.ext.emptyString
import com.dokternak.dokternakid.utils.ext.orZero

fun UserItem.toDomain(): User {
    return User(
        id = this.id ?: emptyString(),
        name = this.name ?: emptyString(),
        email = this.email ?: emptyString(),
        isAdmin = this.isAdmin ?: emptyString(),
        farmerId = this.farmerId.orZero(),
        frontName = this.frontName ?: emptyString(),
        endName = this.endName ?: emptyString(),
        farmerEmail = this.farmerEmail ?: emptyString(),
        phoneNumber = this.phoneNumber ?: emptyString(),
        gender = this.gender ?: emptyString(),
        address = this.address ?: emptyString(),
        farmPicture = this.farmerPicture ?: emptyString()
    )
}