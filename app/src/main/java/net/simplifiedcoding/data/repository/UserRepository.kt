package net.simplifiedcoding.data.repository

import net.simplifiedcoding.data.db.UserDao
import net.simplifiedcoding.data.network.UsersApi
import javax.inject.Inject

class UserRepository @Inject constructor(
  private val api: UsersApi,
  private val userDao: UserDao
) {

  fun getUsers() = networkBoundResource(
    query = { userDao.getUsers() },
    fetch = { api.getUsers() },
    saveFetchResult = { userDao.addUsers(it.data) },
    shouldFetch = { it.isEmpty() }
  )
}