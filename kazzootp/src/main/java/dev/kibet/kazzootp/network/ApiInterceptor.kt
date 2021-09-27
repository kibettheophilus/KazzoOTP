package dev.kibet.kazzootp.network

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val key = ""  //insert your api key
        val request = chain.request().newBuilder()
            .addHeader("Authoration","apikey: $key")
            .build()

        return chain.proceed(request)
    }
}