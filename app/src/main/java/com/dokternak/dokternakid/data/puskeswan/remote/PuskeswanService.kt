package com.dokternak.dokternakid.data.puskeswan.remote

import com.dokternak.dokternakid.data.lib.BaseResponse
import com.dokternak.dokternakid.data.puskeswan.model.PuskeswanItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PuskeswanService {

    @GET("api_puskeswan")
    suspend fun getPuskeswanList(): BaseResponse<List<PuskeswanItem>>

    @GET("api_puskeswan/{id}")
    suspend fun getPuskeswanDetail(
        @Path("id") puskeswanId: String
    ): BaseResponse<PuskeswanItem>

    @GET("api_puskeswan/cari/puskeswan")
    suspend fun searchPuskeswan(
        @Query("nama_puskeswan") puskeswanName: String,
    ): BaseResponse<List<PuskeswanItem>>

}