package net.simplifiedcoding.data.network

import net.simplifiedcoding.data.responses.UsersResponse
import retrofit2.http.GET

interface UsersApi {
  @GET("users")
  suspend fun getUsers(): UsersResponse
}