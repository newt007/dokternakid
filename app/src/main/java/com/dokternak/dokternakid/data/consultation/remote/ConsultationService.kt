package com.dokternak.dokternakid.data.consultation.remote

import com.dokternak.dokternakid.data.consultation.model.ConsultationHistoryItem
import com.dokternak.dokternakid.data.consultation.model.ConsultationItem
import com.dokternak.dokternakid.data.lib.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ConsultationService {

    @FormUrlEncoded
    @POST("api_konsultasi")
    suspend fun addNewConsultation(
        @Field("id_peternak") farmerId: String,
        @Field("id_dokter") doctorId: String,
        @Field("id_kategori") categoryId: String,
        @Field("id_ktg") categoriesId: String,
        @Field("nama_hewan") animalName: String,
        @Field("keluhan") complaint: String,
        @Field("status_kirim") sendStatus: String,
        @Field("tanggal") date: String
    ): BaseResponse<ConsultationItem>

    @GET("api_konsultasi/konsultasiterkirim/{id}")
    suspend fun getSentConsultation(
        @Path("id") id: String
    ): BaseResponse<List<ConsultationItem>>

    @GET("api_konsultasi/konsultasimasuk/{id}")
    suspend fun getInboxConsultation(
        @Path("id") id: String
    ): BaseResponse<List<ConsultationHistoryItem>>

}