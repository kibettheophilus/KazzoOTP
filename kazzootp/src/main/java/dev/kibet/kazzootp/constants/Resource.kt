package dev.kibet.kazzootp.constants

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(val errorString: String): Resource<Nothing>()
}