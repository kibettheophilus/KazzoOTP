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
    @Headers("Content-Type: application/json","apikey: kz_api_key_d49b33706af272c67c7ae8c67fcde107c3f924a65c2ceac3c80647683ab8b94931fae2620875f9d2d1a2327f4dc691c277eeaf2e1e9d5574d8d9996f7388f41b")
    fun sendOtp(
        @Body requestOtp: RequestOtp
    ): Call<RequestSuccess>

    @POST("validate")
    fun validateOtp(
        @Body validateOtp: ValidateOtp
    ): Call<ValidateSuccess>
}