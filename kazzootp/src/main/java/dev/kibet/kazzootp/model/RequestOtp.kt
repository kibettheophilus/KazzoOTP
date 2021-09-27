package dev.kibet.kazzootp.model

data class RequestOtp(
    val recipient: String,
    val channel: String
)
