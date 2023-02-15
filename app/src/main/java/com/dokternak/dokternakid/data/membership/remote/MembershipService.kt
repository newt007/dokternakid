package com.dokternak.dokternakid.data.membership.remote

import com.dokternak.dokternakid.data.lib.BaseResponse
import com.dokternak.dokternakid.data.membership.model.UserItem
import com.dokternak.dokternakid.data.membership.model.response.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

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

}