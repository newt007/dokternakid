package com.dokternak.dokternakid.data.officer.remote

import com.dokternak.dokternakid.data.lib.BaseResponse
import com.dokternak.dokternakid.data.officer.model.OfficerItem
import retrofit2.http.GET
import retrofit2.http.Path

interface OfficerService {

    @GET("api_petugas")
    suspend fun getAllOffices(): BaseResponse<List<OfficerItem>>

    @GET("api_petugas/{id}")
    suspend fun getOfficerDetail(
        @Path("id") id: String
    ): BaseResponse<OfficerItem>

}