package com.dokternak.dokternakid.data.consultation.remote

import com.dokternak.dokternakid.data.consultation.model.ConsultationHistoryItem
import com.dokternak.dokternakid.data.consultation.model.ConsultationItem
import com.dokternak.dokternakid.data.lib.BaseResponse
import retrofit2.http.*

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

    @GET("api_konsultasi/detailmasuk/{id}")
    suspend fun getInboxConsultationDetail(
        @Path("id") historyId: String
    ): BaseResponse<ConsultationHistoryItem>

    @GET("api_konsultasi/detailterkirim/{id}")
    suspend fun getSentConsultationDetail(
        @Path("id") consultId: String
    ): BaseResponse<ConsultationItem>

    @DELETE("api_konsultasi/{id_konsultasi}/hapusterkirim")
    suspend fun deleteSentConsultation(
        @Path("id_konsultasi") consultationId: String
    ): BaseResponse<ConsultationItem>

    @DELETE("api_konsultasi/{id_konsultasi}/hapusmasuk")
    suspend fun deleteInboxConsultation(
        @Path("id_konsultasi") consultationId: String
    ): BaseResponse<ConsultationItem>


}