package com.dokternak.dokternakid.data.membership.model.response

import com.dokternak.dokternakid.data.membership.model.UserItem
import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("success")
    val success: Int?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("user")
    val user: UserItem
)
