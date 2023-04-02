package com.dokternak.dokternakid.data.consultation.model

import com.google.gson.annotations.SerializedName

data class ConsultationHistoryItem(
    @SerializedName("id_riwayat")
    val historyId: Int?,
    @SerializedName("id_konsultasi")
    val consultationId: Int?,
    @SerializedName("id_respon")
    val responseId: Int?,
    @SerializedName("id_peternak")
    val farmerId: Int?,
    @SerializedName("id_dokter")
    val doctorId: Int?,
    @SerializedName("id_kategori")
    val categoryId: Int?,
    @SerializedName("id_kteg")
    val typeId: Int?,
    @SerializedName("id_jabatan")
    val positionId: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("tanggal_respon")
    val responseDate: String?,
    @SerializedName("respon")
    val response: String?,
    @SerializedName("nama_hewan")
    val animalName: String?,
    @SerializedName("keluhan")
    val complaint: String?,
    @SerializedName("tanggal")
    val date: String?,
    @SerializedName("status_kirim")
    val sendStatus: String?,
    @SerializedName("nama_dokter")
    val doctorName: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("jenis_kelamin")
    val gender: String?,
    @SerializedName("alamat")
    val address: String?,
    @SerializedName("tempat")
    val location: String?,
    @SerializedName("telpon")
    val phoneNumber: String?,
    @SerializedName("foto")
    val photo: String?,
    @SerializedName("sertifikasi")
    val certification: String?,
    @SerializedName("jadwal_kerja")
    val workSchedule: String?,
    @SerializedName("verifikasi")
    val verified: String?,
    @SerializedName("namadepan_peternak")
    val frontName: String?,
    @SerializedName("namabelakang_peternak")
    val endName: String?,
    @SerializedName("email_peternak")
    val farmerEmail: String?,
    @SerializedName("no_hp")
    val farmerPhoneNumber: String?,
    @SerializedName("foto_peternak")
    val farmerPicture: String?,
    @SerializedName("kategori_artikel")
    val articleCategory: String?,
    @SerializedName("kategori_hewan")
    val animalCategory: String?
)
