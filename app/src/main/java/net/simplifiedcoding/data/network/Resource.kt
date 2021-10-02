package net.simplifiedcoding.data.network

sealed class Resource<out T> {
  data class Success<out T>(val value: T) : Resource<T>()
  data class Failure(val throwable: Throwable) : Resource<Nothing>()
  object Loading : Resource<Nothing>()
}