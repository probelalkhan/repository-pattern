package net.simplifiedcoding.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface SafeApiCall {
  suspend fun <T> safeApiCall(
    apiCall: suspend () -> T
  ): Resource<T> {
    return withContext(Dispatchers.IO) {
      try {
        Resource.Success(apiCall.invoke())
      } catch (throwable: Throwable) {
        Resource.Failure(throwable)
      }
    }
  }
}