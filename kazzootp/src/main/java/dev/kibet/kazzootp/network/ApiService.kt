package dev.kibet.kazzootp.network

import dev.kibet.kazzootp.model.RequestOtp
import dev.kibet.kazzootp.model.RequestSuccess
import dev.kibet.kazzootp.model.ValidateOtp
import dev.kibet.kazzootp.model.ValidateSuccess
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @POST("send")
    @Headers("Content-Type: application/json","apikey: //insert api key")
    fun sendOtp(
        @Body requestOtp: RequestOtp
    ): Call<RequestSuccess>

    @POST("validate")
    fun validateOtp(
        @Body validateOtp: ValidateOtp
    ): Call<ValidateSuccess>
}