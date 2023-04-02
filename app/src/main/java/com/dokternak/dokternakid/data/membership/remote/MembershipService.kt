package com.dokternak.dokternakid.data.membership.remote

import com.dokternak.dokternakid.data.lib.BaseResponse
import com.dokternak.dokternakid.data.membership.model.UserItem
import com.dokternak.dokternakid.data.membership.model.response.RegisterResponse
import retrofit2.http.*

interface MembershipService {

    @FormUrlEncoded
    @POST("api_users/login/peternak")
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): BaseResponse<UserItem>

    @FormUrlEncoded
    @POST("api_users/register/peternak")
    suspend fun registerUser(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @PUT("api_users/{id}/updatepeternak")
    suspend fun editUserProfile(
        @Path("id") id: Int,
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("email") email: String,
        @Field("no_hp") phoneNumber: String,
        @Field("jenis_kelamin") gender: String,
        @Field("alamat") address: String,
        @Field("nama_gambar") profilePicture: String
    ): BaseResponse<UserItem>

}