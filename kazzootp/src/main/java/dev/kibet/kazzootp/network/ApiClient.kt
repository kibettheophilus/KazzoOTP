package dev.kibet.kazzootp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL = "https://api.kazzo.io/v1/otp/"

    private fun  getRetofit(): Retrofit {
        val  client = OkHttpClient.Builder()
            .addInterceptor(ApiInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun buildApi(): ApiService = getRetofit().create(ApiService::class.java)

}