package com.dokternak.dokternakid.data.puskeswan.model

import com.google.gson.annotations.SerializedName

data class PuskeswanItem(
    @SerializedName("id_puskeswan")
    val puskeswanId: Int?,
    @SerializedName("nama_puskeswan")
    val puskeswanName: String?,
    @SerializedName("alamat")
    val address: String?,
    @SerializedName("wilker")
    val workingArea: String?,
    @SerializedName("jam_kerja")
    val workingTime: String?,
    @SerializedName("gambar")
    val puskeswanImage: String?,
    @SerializedName("nomer")
    val phoneNumber: String?,
    @SerializedName("maps")
    val puskeswanMaps: String?
)
