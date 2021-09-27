package dev.kibet.kazzootp.model

data class ValidateOtp(
    val recipient: String,
    val otp: String
)