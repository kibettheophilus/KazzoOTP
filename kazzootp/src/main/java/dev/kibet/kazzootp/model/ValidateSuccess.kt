package dev.kibet.kazzootp.model

data class ValidateSuccess(
    val `data`: Data,
    val message: String,
    val status: Int
)