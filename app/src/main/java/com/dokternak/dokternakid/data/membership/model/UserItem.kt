package com.dokternak.dokternakid.data.membership.model

import com.google.gson.annotations.SerializedName

data class UserItem (
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("is_admin")
    val isAdmin: String?,
    @SerializedName("id_peternak")
    val farmerId: Long?,
    @SerializedName("namadepan_peternak")
    val frontName: String?,
    @SerializedName("namabelakang_peternak")
    val endName: String?,
    @SerializedName("email_peternak")
    val farmerEmail: String?,
    @SerializedName("no_hp")
    val phoneNumber: String?,
    @SerializedName("jenis_kelamin")
    val gender: String?,
    @SerializedName("alamat")
    val address: String?,
    @SerializedName("foto_peternak")
    val farmerPicture: String?
)
