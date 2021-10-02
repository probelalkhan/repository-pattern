package net.simplifiedcoding.data.repository

import kotlinx.coroutines.flow.flow
import net.simplifiedcoding.data.network.Resource

import kotlinx.coroutines.flow.*

/*
* Thanks to CodingInFlow
* for this code
* Repo Link: https://github.com/codinginflow/SimpleCachingExample
* */

inline fun <ResultType, RequestType> networkBoundResource(
  crossinline query: () -> Flow<ResultType>,
  crossinline fetch: suspend () -> RequestType,
  crossinline saveFetchResult: suspend (RequestType) -> Unit,
  crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {
  val data = query().first()
  val flow = if (shouldFetch(data)) {
    emit(Resource.Loading)
    try {
      saveFetchResult(fetch())
      query().map { Resource.Success(it) }
    } catch (throwable: Throwable) {
      query().map { Resource.Failure(throwable) }
    }
  } else {
    query().map { Resource.Success(it) }
  }
  emitAll(flow)
}