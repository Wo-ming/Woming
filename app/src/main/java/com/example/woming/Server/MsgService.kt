package com.example.woming.Server

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MsgService {
    @FormUrlEncoded
    @POST("app_msg/")
    fun requestMsg(//INPUT
        @Field("msg") mgs:String
    ): Call<Message>
}