package com.dokternak.dokternakid.data.officer.model

import com.google.gson.annotations.SerializedName

data class OfficerItem(
    @SerializedName("id_dokter")
    val doctorId: Int?,
    @SerializedName("nama_dokter")
    val doctorName: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("jenis_kelamin")
    val gender: String?,
    @SerializedName("alamat")
    val address: String?,
    @SerializedName("tempat")
    val place: String?,
    @SerializedName("telpon")
    val phone: String?,
    @SerializedName("foto")
    val photo: String?,
    @SerializedName("sertifikasi")
    val certification: String?,
    @SerializedName("id_jabatan")
    val positionId: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("jadwal_kerja")
    val schedule: String?,
    @SerializedName("verifikasi")
    val verified: String?,
    @SerializedName("jabatan")
    val position: String?,
)
