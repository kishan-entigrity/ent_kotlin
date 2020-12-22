package com.mycpe.myappkot.WebServices

import LoginResponseNew
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("login")
    fun login(
            @Header("Accept") accept:String,
            @Field("email") email:String,
            @Field("password") password: String,
            @Field("device_id") device_id: String,
            @Field("device_token") device_token: String,
            @Field("device_type") device_type: String
//    ): Call<LoginResponse>
    ): Call<LoginResponseNew>

}