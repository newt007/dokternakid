package com.dokternak.dokternakid.data.lib

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("status")
    val status: Any,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: T?
)